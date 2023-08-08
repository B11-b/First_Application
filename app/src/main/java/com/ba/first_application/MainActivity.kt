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
                //to pass data from screen to another
                val intent=Intent(this,SecondActivity::class.java)
               intent.putExtra("USERNAME",binding.usernameEditText.text.toString())
               intent.putExtra("message","Hi $username,your hobbies : $sports, Gender is: $gender")
                startActivityForResult(intent,11)


            }
            binding.backButton.setOnClickListener {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Thank You !",Toast.LENGTH_LONG).show()
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
                    startActivity(Intent(this, SecondActivity::class.java))

                    true}
                  R.id.back -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true}
                  else->{
                    super.onOptionsItemSelected(item)
                    true
                  }
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




