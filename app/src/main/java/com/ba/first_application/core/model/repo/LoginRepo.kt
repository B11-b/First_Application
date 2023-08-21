package com.ba.first_application.core.model.repo

import com.ba.first_application.core.data_source.remote.RetroFitClient
import com.ba.first_application.core.model.body.LoginBodyRequest
import com.ba.first_application.core.model.responce.UserResponse
import retrofit2.Response

class LoginRepo {
    val retrofit=RetroFitClient.getInstance("https://dummyjson.com/")

    suspend fun login (username:String,password:String): Response<UserResponse>{
       return retrofit.login(LoginBodyRequest(username,password))
    }
}