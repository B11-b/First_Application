package com.ba.first_application

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.first_application.R
import com.example.first_application.databinding.CommentDetailsBinding

class CommentDetails:AppCompatActivity() {
    lateinit var binding: CommentDetailsBinding
    lateinit var commentAdapter: CommentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CommentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


       // Picasso.get().load(image).into(binding.detailImage)
        //binding.name.text=Fname
        //binding.name.text=Lname
        //binding.email.text=email


    }
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
}