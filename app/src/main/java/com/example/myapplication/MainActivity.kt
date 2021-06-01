package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.network.Post
import com.example.myapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView : RecyclerView
    lateinit var recyclerAdapter : RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerAdapter = RecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        RetrofitClient.getPostsApi().getAllPosts().enqueue(object : retrofit2.Callback<List<Post>>{

            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                response?.body()?.let {
                    recyclerAdapter.setPostListItems(it as MutableList<Post>)
                }
            }
        })
    }
}