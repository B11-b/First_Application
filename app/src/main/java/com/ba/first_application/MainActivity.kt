package com.ba.first_application

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.first_application.databinding.ActivityMainBinding
    class MainActivity: AppCompatActivity() {

        lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.loginButton.setOnClickListener {
                val username=binding.usernameEditText.text
                val password=binding.passwordEditText.text
                var sports=""
                var gender=""
                if(binding.footballCk.isChecked){
                    sports+="Football   "
                }
                if(binding.swimmingCk.isChecked){
                    sports+="Swimming   "
                }
                if(binding.handballCk.isChecked){
                    sports+="Handball   "
                }
                if(binding.maleRB.isChecked){
                    gender="Male"
                }else{
                    gender="Female"
                }

             if ((username.isNotEmpty())&&(password.isNotEmpty())&&(binding.footballCk.isChecked || binding.swimmingCk.isChecked||binding.handballCk.isChecked)&&(binding.maleRB.isChecked || binding.femaleRB.isChecked)){
              Toast.makeText(this,"Hi $username  your hobbies : $sports  Gender is: $gender"   ,Toast.LENGTH_LONG ).show()
           }
                else{
                   Toast.makeText(this,"Please go back ",Toast.LENGTH_LONG ).show()
                }
            }
        }
    }

