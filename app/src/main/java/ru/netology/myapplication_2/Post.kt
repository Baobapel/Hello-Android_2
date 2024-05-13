package ru.netology.myapplication_2

data class Post (
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likes: Int = 999,
    var likedByMe: Boolean = false,
    var share: Int = 1110,
    var views: Int = 1110001
)
