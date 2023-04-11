package uz.bahrom.newsapp_demo.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "news_table")
@Parcelize
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val author: String?,
    val description: String?,
    val source: String?,
    val newsUrl: String,
    val imgUrl: String,
    val time: String,
    val content: String?,
    val category: String,
    val saved: Int = 0
) : Parcelable
