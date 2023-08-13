package com.ba.first_application.model.uttils

import com.ba.first_application.model.Comment
import com.ba.first_application.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
 //   @GET("/api/users?")
 //  suspend fun getUsers(): Response<ResponseUserList>
    @GET("posts")
   suspend fun getPosts():Response<ArrayList<Post>>
    @GET("posts")
   suspend fun getPostsByUser(@Query("userId") userId:Int):Response<ArrayList<Post>>
    @GET("posts/{post_id}/comments")
    suspend fun getComments(@Path("post_id") postId:Int):Response<ArrayList<Comment>>

}