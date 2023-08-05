package com.ba.first_application

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.first_application.databinding.ActivitySecondBinding


class SecondActivity: AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var username=intent.extras?.getString("USERNAME","")
        binding.usernameSecond.text= username

        Toast.makeText(this,intent.extras?.getString("message"),Toast.LENGTH_LONG).show()


       binding.okButton.setOnClickListener {
           val resultCode= if (binding.googleRB.isChecked){
               1
           }else {
               2
           }
           val intent=Intent()
           setResult(resultCode,intent)
           finish()
       }
    }




}