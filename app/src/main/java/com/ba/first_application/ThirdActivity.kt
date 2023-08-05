package com.ba.first_application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.first_application.databinding.ActivityMainBinding
import com.example.first_application.databinding.ActivityThirdBinding


class ThirdActivity: AppCompatActivity() {
    lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinButton.setOnClickListener {
            //to move from activity to another
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}