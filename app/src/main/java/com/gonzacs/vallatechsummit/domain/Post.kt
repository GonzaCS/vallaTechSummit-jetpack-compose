package com.gonzacs.vallatechsummit.domain

data class Post(
    val id: Int,
    val author: User,
    val postImageId: Int,
    var likedBy: List<User>
)
