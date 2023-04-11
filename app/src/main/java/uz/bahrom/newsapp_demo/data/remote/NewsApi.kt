package uz.bahrom.newsapp_demo.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.bahrom.newsapp_demo.data.remote.model.BaseNewData

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("category") category: String?,
        @Query("apiKey") key: String = "a753c325c3ac48199102f1c953fe0ddd"
    ):Response<BaseNewData>
}