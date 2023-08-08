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
import com.example.first_application.databinding.ActivitySecondBinding


class SecondActivity: AppCompatActivity(),myCustomClickListener {
    lateinit var binding: ActivitySecondBinding
    lateinit var postAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // Toast.makeText(this,intent.extras?.getString("message"),Toast.LENGTH_LONG).show()
        val post= arrayListOf(Post("Maldives,South seas","No two trips are alike, so you will find information in this section for a variety of trip types. Whether you prefer staying in a resort or camping under the stars, we’ve included the details you need to be safe and happy on your USA trip.","https://cdn.pixabay.com/photo/2015/03/09/18/34/beach-666122_1280.jpg","",3,"")
                              ,Post(" Bali,indusia","No two trips are alike, so you will find information in this section for a variety of trip types. Whether you prefer staying in a resort or camping under the stars, we’ve included the details you need to be safe and happy on your USA trip.","https://cdn.pixabay.com/photo/2017/12/15/13/51/polynesia-3021072_1280.jpg","",4,""),
                               Post("Morocco","No two trips are alike, so you will find information in this section for a variety of trip types. Whether you prefer staying in a resort or camping under the stars, we’ve included the details you need to be safe and happy on your USA trip.","https://cdn.pixabay.com/photo/2017/01/20/00/30/maldives-1993704_1280.jpg","",4,""),
                               Post("Hurghada","No two trips are alike, so you will find information in this section for a variety of trip types. Whether you prefer staying in a resort or camping under the stars, we’ve included the details you need to be safe and happy on your USA trip.","https://cdn.pixabay.com/photo/2014/01/02/10/14/beach-hut-237489_1280.jpg","",2,""),
                               Post("SwitzerLand","No two trips are alike, so you will find information in this section for a variety of trip types. Whether you prefer staying in a resort or camping under the stars, we’ve included the details you need to be safe and happy on your USA trip.","https://cdn.pixabay.com/photo/2017/01/12/00/14/maldives-1973322_1280.jpg","",5,""),
                               Post("North coast","No two trips are alike, so you will find information in this section for a variety of trip types. Whether you prefer staying in a resort or camping under the stars, we’ve included the details you need to be safe and happy on your USA trip.","https://cdn.pixabay.com/photo/2020/01/15/20/37/sea-4768869_1280.jpg","",4,""),
                               Post("Albania","No two trips are alike, so you will find information in this section for a variety of trip types. Whether you prefer staying in a resort or camping under the stars, we’ve included the details you need to be safe and happy on your USA trip.","https://cdn.pixabay.com/photo/2017/01/12/00/14/maldives-1973322_1280.jpg","",3,""),
                               Post("Bahamas","No two trips are alike, so you will find information in this section for a variety of trip types. Whether you prefer staying in a resort or camping under the stars, we’ve included the details you need to be safe and happy on your USA trip.","https://cdn.pixabay.com/photo/2017/12/15/13/51/polynesia-3021072_1280.jpg","",4,""),
                               Post("YGreece","No two trips are alike, so you will find information in this section for a variety of trip types. Whether you prefer staying in a resort or camping under the stars, we’ve included the details you need to be safe and happy on your USA trip.","https://cdn.pixabay.com/photo/2017/01/20/00/30/maldives-1993704_1280.jpg","",4,""))

        postAdapter=CustomAdapter(post,this)

        binding.postRv.adapter=postAdapter
    }





    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
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
                true
            }

            R.id.next -> {
                startActivity(Intent(this, PostDetails::class.java))
                true
            }

            R.id.back -> {
                startActivity(Intent(this, MainActivity::class.java))

                true
            }
            else -> {
                super.onOptionsItemSelected(item)
                true
            }
        }
    }

    override fun onItemClick(post: Post, position: Int) {
        var intent=Intent(this, PostDetails::class.java)
        intent.putExtra("title",post.title)
        intent.putExtra("details",post.details)
        intent.putExtra("image",post.imageView)
        startActivity(intent)
    }
}