package ru.netology.myapplication_2

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.myapplication_2.databinding.NetologyMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("###", "onCreate")
        setContentView(R.layout.netology_main)
        val binding = NetologyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel: PostViewModel by viewModels()
        viewModel.getMyPost().observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                tvLikes.text = Utils.formatNumber(post.likes)
                tvShares.text = Utils.formatNumber(post.share)
                tvViews.text = Utils.formatNumber(post.views)
                ivLikes.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )

                ivLikes.setOnClickListener {
                    viewModel.likeMyPost()
                }

                ivShare.setOnClickListener {
                    viewModel.shareMyPost()
                }

                ivViews.setOnClickListener {
                    viewModel.viewMyPost()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("###", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("###", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("###", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("###", "onStop")
    }

    override fun onDestroy() {
        Log.i("###", "onDestroy")
        super.onDestroy()

    }
}
