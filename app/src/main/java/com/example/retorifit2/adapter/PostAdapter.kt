package com.example.retorifit2.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retorifit2.R
import com.example.retorifit2.data.UserResponse

class PostAdapter(
        private val list:ArrayList<UserResponse>
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    inner class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun binding(res:UserResponse){
            with(itemView){
                val title:TextView = findViewById(R.id.textViewTitle)
                val subtitle:TextView = findViewById(R.id.textViewBody)

                title.text = res.name
                subtitle.text = res.address.city

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
               .inflate(R.layout.recycleview_posts,parent,false)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}