package com.ba.first_application

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.first_application.R
import com.example.first_application.databinding.PostItemBinding
import com.squareup.picasso.Picasso


class CustomAdapter(var postList:ArrayList<Post>):RecyclerView.Adapter<CustomAdapter.viewHolder>() {
    inner class viewHolder(val binding: PostItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding=PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding)

    }


    override fun getItemCount(): Int {
       return postList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.postName.text=postList[position].name
        holder.binding.postDate.text=postList[position].date
        holder.binding.rate.text= postList[position].rate.toString()

        if(postList[position].imageView.isNotEmpty()) {
            Picasso.get().load(postList[position].imageView).placeholder(R.drawable.loading)
                .into(holder.binding.postImage)
        }


    }

}