package com.example.retorifit2.network

import com.example.retorifit2.data.CommentsResponse
import com.example.retorifit2.data.PostsResponse
import com.example.retorifit2.data.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("users")
    fun getAllDataPost():Call<ArrayList<UserResponse>>

    @GET("posts/{id}/comments")
    fun getCommentByIdPots(
            @Path("id") postId:Int
    ):Call<ArrayList<CommentsResponse>>
}