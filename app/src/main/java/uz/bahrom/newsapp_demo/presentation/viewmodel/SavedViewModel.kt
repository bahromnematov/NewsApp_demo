package uz.bahrom.newsapp_demo.presentation.viewmodel

import kotlinx.coroutines.flow.StateFlow
import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity

interface SavedViewModel {

    val savedNewsFlow: StateFlow<List<NewsEntity>>
}