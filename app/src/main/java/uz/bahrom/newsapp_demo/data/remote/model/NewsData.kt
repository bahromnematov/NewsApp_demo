package uz.bahrom.newsapp_demo.data.remote.model

import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity

data class NewsData(
    val author: String?,
    val description: String?,
    val source: Source,
    val title: String,
    val url: String,
    val urlImage: String,
    val publishedAt: String,
    val content: String?


) {
    fun toNewsEntity(category: String) = NewsEntity(
        0, title, author, description, source.name, url, urlImage, publishedAt, content, category
    )
}
