package uz.bahrom.newsapp_demo.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.bahrom.newsapp_demo.data.local.MyDatabase
import uz.bahrom.newsapp_demo.data.local.dao.NewsDao
import uz.bahrom.newsapp_demo.data.remote.NewsApi
import uz.bahrom.newsapp_demo.data.shared_prefs.MyPref
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val baseUrl = "https://newsapi.org/v2/"

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext ctx: Context): MyDatabase =
        Room.databaseBuilder(ctx, MyDatabase::class.java, "news_data.db")
            .fallbackToDestructiveMigration().build()


    @[Provides Singleton]
    fun provideNewsDao(appDatabase: MyDatabase): NewsDao = appDatabase.newsDao()


    @[Provides Singleton]
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @[Provides Singleton]
    fun provideNewsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)


    @[Provides Singleton]
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("app_data", Context.MODE_PRIVATE)


    @[Provides Singleton]
    fun provideSharedPrefs(
        @ApplicationContext context: Context,
        sharedPreferences: SharedPreferences
    ): MyPref =
        MyPref(context, sharedPreferences)

}