package com.ba.first_application.core.model.responce

import com.ba.first_application.core.model.Support
import com.ba.first_application.core.model.User
import com.google.gson.annotations.SerializedName

data class ResponseUserList(
    @SerializedName("page")
    var page:Int,
    @SerializedName("per_page")
    var per_page :Int,
    @SerializedName("total")
    var total:Int,
    @SerializedName("total_pages")
    var total_pages:Int,
    @SerializedName("data")
    var data: ArrayList<User>,
    @SerializedName("support")
    var support: Support
) {
}