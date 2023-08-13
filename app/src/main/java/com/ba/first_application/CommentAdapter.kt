package com.ba.first_application

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ba.first_application.model.Comment
import com.ba.first_application.model.Post
import com.example.first_application.databinding.CommentItemBinding
import com.example.first_application.databinding.PostItemBinding

class CommentAdapter(var CommentList:ArrayList<Comment>, var listener: myCustomClickListener): RecyclerView.Adapter<CommentAdapter.viewHolder>() {
    inner class viewHolder(val binding: CommentItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  CommentAdapter.viewHolder {
        val binding= CommentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding)

    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.commentId.text=CommentList[position].id.toString()
        holder.binding.postId.text=CommentList[position].postId.toString()
        holder.binding.commentName.text=CommentList[position].name
        holder.binding.commentEmail.text=CommentList[position].email
        holder.binding.commentBody.text=CommentList[position].body

        holder.binding.root.setOnClickListener{
            listener.onItemClick2(CommentList[position],position)
        }
    }


    override fun getItemCount(): Int {
        return CommentList.size
    }


}