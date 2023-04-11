package uz.bahrom.newsapp_demo.repository

import kotlinx.coroutines.flow.Flow
import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity
import uz.bahrom.newsapp_demo.utils.ResultData

interface NewsRepository {

    fun getAllNewsByCategory(category: String): Flow<List<NewsEntity>>


    suspend fun requestByCategory(category: String): ResultData<Boolean>

    suspend fun updateNews(newsEntity: NewsEntity)

    fun getAllSavedNews(): Flow<List<NewsEntity>>
}