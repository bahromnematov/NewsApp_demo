package uz.bahrom.newsapp_demo.presentation.viewmodel.impl

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity
import uz.bahrom.newsapp_demo.presentation.viewmodel.SavedViewModel
import uz.bahrom.newsapp_demo.repository.NewsRepository
import javax.inject.Inject

@HiltViewModel
class SavedViewModelImpl @Inject constructor(
    private val repository: NewsRepository
) : SavedViewModel, ViewModel() {
    override val savedNewsFlow = MutableStateFlow<List<NewsEntity>>(emptyList())


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllSavedNews().collectLatest {
                savedNewsFlow.emit(it)
            }
        }

    }

}