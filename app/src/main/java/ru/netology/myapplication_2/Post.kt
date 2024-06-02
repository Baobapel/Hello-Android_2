package ru.netology.myapplication_2

data class Post (
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likes: Int,
    val likedByMe: Boolean,
    val share: Int,
    val views: Int
)
