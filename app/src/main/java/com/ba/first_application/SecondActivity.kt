package com.ba.first_application

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ba.first_application.model.Post
import com.ba.first_application.model.uttils.ApiInterface
import com.ba.first_application.model.uttils.RetroFitClient
import com.example.first_application.R
import com.example.first_application.databinding.ActivitySecondBinding
import retrofit2.Retrofit
import retrofit2.create


class SecondActivity: AppCompatActivity(),myCustomClickListener {
    lateinit var binding: ActivitySecondBinding
    lateinit var postAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
       Toast.makeText(this,intent.extras?.getString("message"),Toast.LENGTH_LONG).show()
        val post= arrayListOf(
            Post(  1, "" ,"Maldives,South seas","No two trips are alike.","https://cdn.pixabay.com/photo/2015/03/09/18/34/beach-666122_1280.jpg"),
            Post(1, "" ," Bali,indusia","No two trips are alike","https://cdn.pixabay.com/photo/2017/12/15/13/51/polynesia-3021072_1280.jpg"),
                               Post(1, "" ,"Morocco","No two trips are alike.","https://cdn.pixabay.com/photo/2017/01/20/00/30/maldives-1993704_1280.jpg"),
                               Post(1, "" ,"Hurghada","No two trips are alike.","https://cdn.pixabay.com/photo/2014/01/02/10/14/beach-hut-237489_1280.jpg"),
                               Post(1, "" ,"SwitzerLand","No two trips are alike.","https://cdn.pixabay.com/photo/2017/01/12/00/14/maldives-1973322_1280.jpg"),
                               Post(1, "" ,"North coast","No two trips are alike ","https://cdn.pixabay.com/photo/2020/01/15/20/37/sea-4768869_1280.jpg"),
                               Post(1, "" ,"Albania","No two trips are alike.","https://cdn.pixabay.com/photo/2017/01/12/00/14/maldives-1973322_1280.jpg"),
                               Post(1, "" ,"Bahamas","No two trips are alike","https://cdn.pixabay.com/photo/2017/12/15/13/51/polynesia-3021072_1280.jpg"),
                               Post(1, "" ,"YGreece","No two trips are alike.","https://cdn.pixabay.com/photo/2017/01/20/00/30/maldives-1993704_1280.jpg")
        )




            var retrofit=RetroFitClient.getInstance().create(ApiInterface::class.java)
            lifecycleScope.launchWhenCreated {
                val response= retrofit.getUsers()
                if (response.isSuccessful) {
                    postAdapter= (CustomAdapter(response.body()?.data ?: arrayListOf<Post>(),this@SecondActivity))
                    binding.postRv.adapter=postAdapter

                }else{
                    Toast.makeText(this@SecondActivity,"error!",Toast.LENGTH_SHORT).show()
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
                startActivity(Intent(this, MainActivity::class.java))
                finish()
               true

            }

            R.id.next -> {
                startActivity(Intent(this, PostDetails::class.java))
                true
            }

            R.id.back -> {
                startActivity(Intent(this, MainActivity::class.java))

                true
            }
            else -> {
                super.onOptionsItemSelected(item)
                true
            }
        }
    }

    override fun onItemClick(post: Post, position: Int) {
        var intent=Intent(this, PostDetails::class.java)
        intent.putExtra("title",post.name)
        intent.putExtra("details",post.details)
        intent.putExtra("name",post.name)
        intent.putExtra("image",post.imageView)
        startActivity(intent)
    }


}