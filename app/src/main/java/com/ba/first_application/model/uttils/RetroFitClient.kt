package com.ba.first_application.model.uttils

import android.annotation.SuppressLint
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetroFitClient {
    //https://jsonplaceholder.typicode.com/
    //https://dummyjson.com/
    @SuppressLint("SuspiciousIndentation")
    fun getInstance(baseUrl:String):ApiInterface{
       var interceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

         var okHttpClient=OkHttpClient.Builder().addInterceptor(interceptor).build()

           return Retrofit.Builder()
               .baseUrl(baseUrl)
               .addConverterFactory(GsonConverterFactory.create())
               .client(okHttpClient)
               .build().create(ApiInterface::class.java)
    }
}