package com.ba.first_application.core.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id:Int,
    @SerializedName("first_name")
    var Fname:String,
    @SerializedName("last_name")
    var Lname:String,
    @SerializedName("email")
    var email:String,
    @SerializedName("avatar")
    var imageView: String, ) {

}

