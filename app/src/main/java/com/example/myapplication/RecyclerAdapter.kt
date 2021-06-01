package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.network.Post

class RecyclerAdapter(val context : Context) : RecyclerView.Adapter<RecyclerAdapter.Holder>() {

    var postList : MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_adapter,parent,false)
        return Holder(view)
    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.name.text = postList[position].title
    }

    fun setPostListItems (post : MutableList<Post>) {
        this.postList= post
        notifyDataSetChanged()
    }

    class Holder (view : View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.name)
    }

}