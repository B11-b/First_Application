package com.ba.first_application.ui.second

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ba.first_application.CommentDetails
import com.ba.first_application.CustomAdapter
import com.ba.first_application.core.model.Post
import com.ba.first_application.core.data_source.remote.ApiInterface
import com.ba.first_application.core.data_source.remote.RetroFitClient
import com.ba.first_application.myCustomClickListener
import com.ba.first_application.ui.login.loginActivity
import com.example.first_application.R
import com.example.first_application.databinding.ActivitySecondBinding


class SecondActivity: AppCompatActivity(), myCustomClickListener {
    lateinit var binding: ActivitySecondBinding
    lateinit var postAdapter: CustomAdapter
    lateinit var retrofit: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit= RetroFitClient.getInstance("https://jsonplaceholder.typicode.com/")

        binding.submitButton.setOnClickListener {

            lifecycleScope.launchWhenCreated {
                val response= retrofit.getPostsByUser(binding.postText.text.toString().toInt())
                if (response.isSuccessful) {
                    postAdapter= (CustomAdapter(response.body()?:ArrayList<Post>(),this@SecondActivity))
                    binding.postRv.layoutManager = LinearLayoutManager(this@SecondActivity)
                    binding.postRv.adapter=postAdapter

                }else{
                    Toast.makeText(this@SecondActivity,"error!",Toast.LENGTH_SHORT).show()
                }
            }
        }





    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.exit -> {
                val SharedPref=applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)
                val editor=SharedPref.edit()
                editor.remove("USERNAME")
                editor.remove("Password")
                editor.putBoolean("IS_LOGGIN",false)
                editor.commit()
                startActivity(Intent(this, loginActivity::class.java))
                finish()
               true

            }

            R.id.next -> {
                startActivity(Intent(this, CommentDetails::class.java))
                true
            }

            R.id.back -> {
                startActivity(Intent(this, loginActivity::class.java))

                true
            }
            else -> {
                super.onOptionsItemSelected(item)
                true
            }
        }
    }



    override fun onItemClick(post: Post, position: Int) {
        val intent=Intent(this@SecondActivity, CommentDetails::class.java)
        intent.putExtra("postId",post.id)
        startActivity(intent)
     }



}