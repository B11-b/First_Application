package com.ba.first_application.core.model

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("userId")
    var UserId:Int,
    @SerializedName("id")
    var id:Int,
    @SerializedName("title")
    var title:String,
    @SerializedName("body")
    var body:String){
}