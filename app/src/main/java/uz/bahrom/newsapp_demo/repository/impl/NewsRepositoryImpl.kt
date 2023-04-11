package uz.bahrom.newsapp_demo.repository.impl

import kotlinx.coroutines.flow.Flow
import uz.bahrom.newsapp_demo.data.local.dao.NewsDao
import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity
import uz.bahrom.newsapp_demo.data.remote.NewsApi
import uz.bahrom.newsapp_demo.repository.NewsRepository
import uz.bahrom.newsapp_demo.utils.ResultData
import uz.bahrom.newsapp_demo.utils.hasConnection
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val dao: NewsDao
) : NewsRepository {
    override fun getAllNewsByCategory(category: String) = dao.getAllNewsByCategory(category)


    override suspend fun requestByCategory(category: String): ResultData<Boolean> {
        if (hasConnection()) {
            try {
                val data = api.getNews(country = "in", category = category.lowercase())
                return if (data.isSuccessful) {

                    if (data.body() != null) {
                        val body = data.body()!!
                        dao.insertNews(body.articles.map { it.toNewsEntity(category) })
                        ResultData.Success(true)
                    } else {
                        ResultData.Error(Throwable("Body null"))
                    }
                } else {
                    ResultData.Error(Throwable(data.message()))
                }
            } catch (e: Exception) {
                return ResultData.Error(e)
            }
        } else {
            return ResultData.Message("No internet connection")
        }
    }

    override suspend fun updateNews(newsEntity: NewsEntity) {
        dao.updateNews(newsEntity)
    }

    override fun getAllSavedNews(): Flow<List<NewsEntity>> = dao.getAllSavedNews()


}