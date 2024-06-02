package ru.netology.myapplication_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()

    fun getMyPost(): LiveData<Post> = repository.getMyPost()
    fun likeMyPost() = repository.likeMyPost()
    fun viewMyPost() = repository.viewMyPost()
    fun shareMyPost() = repository.shareMyPost()

}