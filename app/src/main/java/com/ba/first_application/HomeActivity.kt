package com.ba.first_application

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.first_application.R
import com.example.first_application.databinding.ActivityHomeBinding

class HomeActivity:AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signinButton.setOnClickListener {
            //to move from activity to another
            startActivity(Intent(this,MainActivity::class.java))
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
}