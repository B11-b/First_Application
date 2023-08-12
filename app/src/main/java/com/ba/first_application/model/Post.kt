package com.ba.first_application.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("id ")
    var id:Int,
    @SerializedName("email ")
    var title:String,
    @SerializedName("first_name")
    var name:String,
    @SerializedName("last_name")
    var details:String,
    @SerializedName("avatar")
    var imageView: String, ) {

}

