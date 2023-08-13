package com.ba.first_application

import com.ba.first_application.model.Comment
import com.ba.first_application.model.Post
import com.ba.first_application.model.User

interface myCustomClickListener {
    fun onItemClick(post: Post, position:Int)

}