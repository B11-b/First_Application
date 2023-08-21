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
import com.ba.first_application.core.model.Comment
import com.ba.first_application.core.model.Post
import com.ba.first_application.core.data_source.remote.ApiInterface
import com.ba.first_application.core.data_source.remote.RetroFitClient
import com.ba.first_application.ui.second.SecondActivity
import com.example.first_application.R
import com.example.first_application.databinding.CommentDetailsBinding

class CommentDetails:AppCompatActivity(),myCustomClickListener{
    lateinit var binding: CommentDetailsBinding
    lateinit var commentAdapter: CommentAdapter
    lateinit var retrofit: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CommentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit= RetroFitClient.getInstance("https://jsonplaceholder.typicode.com/")
        lifecycleScope.launchWhenCreated {
            val response= retrofit.getComments(intent.extras?.getInt("postId")?: 0 )
            if (response.isSuccessful) {
              val comments= response.body()?:ArrayList<Comment>()
                binding.commentRv.adapter=CommentAdapter(comments)

            }else{

            }
//        var response= retrofit.getComments(intent.extras?.getInt("postId").toString())
//        if (response.isSuccessful) { var comments=response.body()?: ArrayList<Comment>()
//
//            binding.commentRv.adapter=CommentAdapter(comments)
//
//        }else{
//
//        }
        }
       // Picasso.get().load(image).into(binding.detailImage)
        //binding.name.text=Fname
        //binding.name.text=Lname
        //binding.email.text=email


    }


   // override fun onItemClick2(comment: Comment, position: Int) {

    //}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.exit -> {
                val dialogBuilder: AlertDialog.Builder= AlertDialog.Builder(this)
                dialogBuilder.setTitle(R.string.Title)
                dialogBuilder.setMessage(R.string.msg)
                dialogBuilder.setCancelable(true)
                dialogBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                    finish()
                })
                dialogBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                    dialog.cancel()
                })
                val alertDialog=dialogBuilder.create()
                alertDialog.show()
                true}
            R.id.next -> {
                Toast.makeText(this,"error!", Toast.LENGTH_SHORT).show()
                true}
            R.id.back -> {
                startActivity(Intent(this, SecondActivity::class.java))
                true}
            else->{
                super.onOptionsItemSelected(item)
                true
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onItemClick(post: Post, position: Int) {
        TODO("Not yet implemented")
    }


}