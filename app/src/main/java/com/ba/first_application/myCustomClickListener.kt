package com.ba.first_application

import com.ba.first_application.core.model.Post

interface myCustomClickListener {
    fun onItemClick(post: Post, position:Int)

}