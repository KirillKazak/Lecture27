package com.example.myapplication.network

import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    fun getAllPosts() : retrofit2.Call<List<Post>>
}