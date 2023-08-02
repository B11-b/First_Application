package com.ba.first_application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.first_application.databinding.ActivityMainBinding
    class MainActivity: AppCompatActivity() {

        lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)

            setContentView(binding.root)

            binding.loginButton.setOnClickListener {

                println(binding.usernameEditText.text)
                println(binding.passwordEditText.text)

            }
        }
    }
