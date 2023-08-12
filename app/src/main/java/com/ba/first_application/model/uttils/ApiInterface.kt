package com.ba.first_application.model.uttils

import com.ba.first_application.model.ResponseUserList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/api/users?")
   suspend fun getUsers(): Response<ResponseUserList>
}