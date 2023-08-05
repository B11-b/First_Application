package com.ba.first_application

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.first_application.R
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
               var gender=""
               var sports=""
               if(binding.footballCk.isChecked){
                   sports+="Football,"
               }
               if(binding.swimmingCk.isChecked){
                   sports+="Swimming,"
               }
               if(binding.handballCk.isChecked){
                   sports+="Handball "
               }
               if(binding.maleRB.isChecked){
                   gender="Male"
               }else{
                   gender="Female"
               }
             /*  if ((username.isNotEmpty())&&(password.isNotEmpty())&&
                   ((binding.footballCk.isChecked)|| (binding.swimmingCk.isChecked) ||(binding.handballCk.isChecked))
                   &&((binding.maleRB.isChecked)|| (binding.femaleRB.isChecked))){
                   Toast.makeText(this,"Hi $username  your hobbies : $sports  Gender is: $gender"   ,Toast.LENGTH_SHORT ).show()
               }
               else{
                   Toast.makeText(this,"Please go back ",Toast.LENGTH_LONG ).show()
               }*/
                //to pass data from screen to another
                val intent=Intent(this,SecondActivity::class.java)
                intent.putExtra("USERNAME",binding.usernameEditText.text.toString())
               intent.putExtra("message","Hi $username  your hobbies : $sports  Gender is: $gender")
                startActivityForResult(intent,11)


            }
            binding.backbutton.setOnClickListener {

               Toast.makeText(this,"Thank you ! ",Toast.LENGTH_LONG ).show()

                }
            }


        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if(requestCode==11){
                if (resultCode==1){
                    Toast.makeText(this,"Logged in by Google",Toast.LENGTH_LONG).show()
                }
                else if(resultCode==2){
                    Toast.makeText(this,"Logged in by Facebook",Toast.LENGTH_LONG).show()
                }

            }
        }

        }




