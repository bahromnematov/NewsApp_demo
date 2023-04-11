package uz.bahrom.newsapp_demo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.bahrom.newsapp_demo.data.local.dao.NewsDao
import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}