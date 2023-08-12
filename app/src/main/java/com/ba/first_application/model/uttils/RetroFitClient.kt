package com.ba.first_application.model.uttils

import android.annotation.SuppressLint
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitClient {
    @SuppressLint("SuspiciousIndentation")
    fun getInstance():Retrofit{
       var interceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
         var okHttpClient=OkHttpClient.Builder().addInterceptor(interceptor).build()
         var retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
           return retrofit
    }
}