package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit : Retrofit? = null
    private const val baseUrl = "https://jsonplaceholder.typicode.com/"

    private fun getClient() = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    fun getPostsApi() : PostApi {
        if (retrofit == null) {
            retrofit = getClient()
        }
        return retrofit!!.create(PostApi::class.java)
    }
}