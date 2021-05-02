package com.example.retorifit2.data

data class CommentsResponse(
        var postId :Int,
        var id :Int,
        var name :String,
        var email :String,
        var body : String
)