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
import com.example.first_application.databinding.ActivityHomeBinding



class HomeActivity: AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinButton.setOnClickListener {
            //to move from activity to another
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.forgetPass.setOnClickListener {
            //create dialog
            val dialogBuilder: AlertDialog.Builder= AlertDialog.Builder(this)
            dialogBuilder.setTitle(R.string.Title)
            dialogBuilder.setMessage(R.string.Forget_pass)
            dialogBuilder.setCancelable(true)
            dialogBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->

                Toast.makeText(this,"Restored your password", Toast.LENGTH_LONG).show()
            })
            dialogBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Okay Thank You", Toast.LENGTH_LONG).show()
            })
            val alertDialog=dialogBuilder.create()
            alertDialog.show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu,menu)
        return true
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
                val dialogBuilder: AlertDialog.Builder= AlertDialog.Builder(this)
                dialogBuilder.setMessage(R.string.Title)
                dialogBuilder.setCancelable(true)
                dialogBuilder.setPositiveButton("Continue", DialogInterface.OnClickListener { dialog, which ->
                    startActivity(Intent(this,MainActivity::class.java))
                })
                val alertDialog=dialogBuilder.create()
                alertDialog.show()
                true}
            R.id.back -> {
                Toast.makeText(this,"Can't go back!",Toast.LENGTH_SHORT).show()
                true}
            else->{
                super.onOptionsItemSelected(item)
                true
            }
        }
    }
}