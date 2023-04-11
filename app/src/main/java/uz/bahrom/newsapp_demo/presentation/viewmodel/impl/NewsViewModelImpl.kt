package uz.bahrom.newsapp_demo.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity
import uz.bahrom.newsapp_demo.presentation.viewmodel.NewsViewModel
import uz.bahrom.newsapp_demo.repository.NewsRepository
import uz.bahrom.newsapp_demo.utils.getMessage
import javax.inject.Inject

@HiltViewModel
class NewsViewModelImpl @Inject constructor(
    private val repository: NewsRepository
) : NewsViewModel, ViewModel() {


    override val loadingProgressBar = MutableSharedFlow<Boolean>()

    override val messageSharedFlow = MutableSharedFlow<String>()

    override val errorSharedFlow = MutableSharedFlow<String>()

    override val newsSharedFlow = MutableSharedFlow<List<NewsEntity>>()


    override fun getNewsByCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loadingProgressBar.emit(true)
            repository.requestByCategory(category)
                .onError {
                    errorSharedFlow.emit(it.getMessage())
                }
                .onMessage {
                    messageSharedFlow.emit(it)
                }
                .onSuccess {
                    loadingProgressBar.emit(false)
                    repository.getAllNewsByCategory(category).collectLatest {
                        newsSharedFlow.emit(it)
                    }
                }
        }
    }
}