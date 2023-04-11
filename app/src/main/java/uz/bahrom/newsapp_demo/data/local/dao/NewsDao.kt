package uz.bahrom.newsapp_demo.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(newsEntity: NewsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(list: List<NewsEntity>)

    @Update
    suspend fun updateNews(newsEntity: NewsEntity)

    @Query("SELECT*FROM news_table WHERE category=:category ORDER BY id DESC")
    fun getAllNewsByCategory(category: String): Flow<List<NewsEntity>>

    @Query("SELECT*FROM news_table WHERE saved==1")
    fun getAllSavedNews(): Flow<List<NewsEntity>>


    @Query("DELETE FROM news_table WHERE saved!=1")
    suspend fun deleteAllNews()


    @Query("DELETE FROM news_table WHERE saved==1")
    suspend fun deleteAllSavedNews()


    @Transaction
    suspend fun refreshData(list: List<NewsEntity>) {
        deleteAllNews()
        insertNews(list)
    }
}