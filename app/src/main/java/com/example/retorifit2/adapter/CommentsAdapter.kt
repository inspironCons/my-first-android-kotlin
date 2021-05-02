package com.example.retorifit2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retorifit2.R
import com.example.retorifit2.data.CommentsResponse

class CommentsAdapter(
        private val listComment: ArrayList<CommentsResponse>
):RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>(){
    inner class CommentViewHolder(
            itemView: View
    ):RecyclerView.ViewHolder(itemView){
        fun bind(res:CommentsResponse){
            with(itemView){
                val title: TextView = findViewById(R.id.textViewTitle)
                val subtitle: TextView = findViewById(R.id.textViewBody)

                title.text = res.name
                subtitle.text = res.body
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycleview_posts,parent,false)

        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(listComment[position])
    }

    override fun getItemCount(): Int {
        return listComment.size
    }
}