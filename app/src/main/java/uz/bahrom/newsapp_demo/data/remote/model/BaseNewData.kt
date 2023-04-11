package uz.bahrom.newsapp_demo.data.remote.model

import uz.bahrom.newsapp_demo.data.local.dao.NewsDao

data class BaseNewData(
    val articles: List<NewsData>,
    val status: String,
    val totalResults: Int
)