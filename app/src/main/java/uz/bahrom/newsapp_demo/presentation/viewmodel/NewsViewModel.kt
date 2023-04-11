package uz.bahrom.newsapp_demo.presentation.viewmodel

import kotlinx.coroutines.flow.SharedFlow
import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity

interface NewsViewModel {

    val loadingProgressBar: SharedFlow<Boolean>

    val messageSharedFlow: SharedFlow<String>

    val errorSharedFlow: SharedFlow<String>

    val newsSharedFlow: SharedFlow<List<NewsEntity>>


    fun getNewsByCategory(category: String)
}