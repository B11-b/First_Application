package com.ba.first_application.core.data_source.remote

import android.annotation.SuppressLint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitClient {
    //https://jsonplaceholder.typicode.com/
    //https://dummyjson.com/
    @SuppressLint("SuspiciousIndentation")
    fun getInstance(baseUrl:String): ApiInterface {
       var interceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

         var okHttpClient=OkHttpClient.Builder().addInterceptor(interceptor).build()

           return Retrofit.Builder()
               .baseUrl(baseUrl)
               .addConverterFactory(GsonConverterFactory.create())
               .client(okHttpClient)
               .build().create(ApiInterface::class.java)
    }
}