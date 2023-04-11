package uz.bahrom.newsapp_demo.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity
import uz.bahrom.newsapp_demo.presentation.viewmodel.ReadViewModel
import uz.bahrom.newsapp_demo.repository.NewsRepository
import javax.inject.Inject

@HiltViewModel
class ReadViewModelImpl @Inject constructor(
    private val repository: NewsRepository
) : ReadViewModel, ViewModel() {
    override fun updateNews(newsEntity: NewsEntity) {
        viewModelScope.launch {
            repository.updateNews(newsEntity)
        }
    }
}