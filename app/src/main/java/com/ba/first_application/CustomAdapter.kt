package com.ba.first_application

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ba.first_application.core.model.Post
import com.example.first_application.databinding.PostItemBinding


class CustomAdapter(var PostList:ArrayList<Post>, var listener: myCustomClickListener): RecyclerView.Adapter<CustomAdapter.viewHolder>() {
    inner class viewHolder(val binding: PostItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding=PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding)

    }


    override fun getItemCount(): Int {
       return PostList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.userId.text=" UserId:${PostList[position].UserId} "

        holder.binding.postId.text="PostId:${PostList[position].id}"

        holder.binding.postTitle.text="Post title:${PostList[position].title}"

        holder.binding.postBody.text="Body:${PostList[position].body}"


        /*if(PostList[position].imageView.isNotEmpty()) {
            Picasso.get().load(PostList[position].imageView).placeholder(R.drawable.loading).into(holder.binding.postImage)
        }*/
       holder.binding.root.setOnClickListener{
           listener.onItemClick(PostList[position],position)
       }

    }


}