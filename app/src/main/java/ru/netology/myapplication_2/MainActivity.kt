package ru.netology.myapplication_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.myapplication_2.databinding.NetologyMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.netology_main)
        val binding = NetologyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36"
        )


        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            tvLikes.text = Utils.formatNumber(post.likes)
            tvShares.text = Utils.formatNumber(post.share)
            tvViews.text = Utils.formatNumber(post.views)

            if (post.likedByMe) {
                ivLikes.setImageResource(R.drawable.ic_liked_24)
            } else ivLikes.setImageResource(R.drawable.ic_like_24)

            ivLikes.setOnClickListener {
                post.likedByMe = !post.likedByMe
                ivLikes.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )
                if (post.likedByMe) post.likes++ else post.likes--
                tvLikes.text = Utils.formatNumber(post.likes)

            }

            ivShare.setOnClickListener {
                post.share++
                tvShares.text = Utils.formatNumber(post.share)
            }

            ivViews.setOnClickListener {
                post.views++
                tvViews.text = Utils.formatNumber(post.views)
            }
        }
    }
}
