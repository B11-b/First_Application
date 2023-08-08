package com.ba.first_application

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.first_application.R
import com.example.first_application.databinding.ActivitySplashBinding

class SplashActivity:AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //to activate the theme that i put in themes
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({startActivity(Intent(this,HomeActivity::class.java))},2000)
    }
}