package uz.bahrom.newsapp_demo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.bahrom.newsapp_demo.repository.NewsRepository
import uz.bahrom.newsapp_demo.repository.impl.NewsRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {


    @[Binds Singleton]
    fun bindsRepository(impl: NewsRepositoryImpl): NewsRepository
}