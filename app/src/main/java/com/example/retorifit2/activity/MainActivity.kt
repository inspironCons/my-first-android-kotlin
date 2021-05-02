package com.example.retorifit2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retorifit2.R
import com.example.retorifit2.adapter.CommentsAdapter
import com.example.retorifit2.adapter.PostAdapter
import com.example.retorifit2.data.CommentsResponse
import com.example.retorifit2.data.PostsResponse
import com.example.retorifit2.data.UserResponse
import com.example.retorifit2.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<UserResponse>()
    private val listComment = ArrayList<CommentsResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPost()
//        getCommentByIdPost()
    }

    private fun getCommentByIdPost() {
        val rv:RecyclerView = findViewById(R.id.rvListPost)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instace.getCommentByIdPots(1).enqueue(object:Callback<ArrayList<CommentsResponse>>{
            override fun onResponse(call: Call<ArrayList<CommentsResponse>>, response: Response<ArrayList<CommentsResponse>>) {
                if(response.isSuccessful){
                    val tvRes:TextView = findViewById(R.id.tvCodeRes)
                    response.body()?.let { listComment.addAll(it) }
                    tvRes.text = response.code().toString()
                    rv.adapter = CommentsAdapter(listComment)
                }
            }

            override fun onFailure(call: Call<ArrayList<CommentsResponse>>, t: Throwable) {
                Log.e("errors get api","${t.message}")
            }

        })
    }

    private fun getPost() {
        val rv:RecyclerView = findViewById(R.id.rvListPost)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        RetrofitClient.instace
                .getAllDataPost()
                .enqueue(object : Callback<ArrayList<UserResponse>>{
                    override fun onResponse(call: Call<ArrayList<UserResponse>>, response: Response<ArrayList<UserResponse>>) {
                        if(response.isSuccessful){
                            val tvRes:TextView = findViewById(R.id.tvCodeRes)
                            response.body()?.let { list.addAll(it) }
                            tvRes.text = response.code().toString()
                            Log.d("res","${list}")
                            rv.adapter = PostAdapter(list)
                        }
                    }

                    override fun onFailure(call: Call<ArrayList<UserResponse>>, t: Throwable) {
                        Log.e("errors get api","${t.message}")

                    }

                })
    }


}