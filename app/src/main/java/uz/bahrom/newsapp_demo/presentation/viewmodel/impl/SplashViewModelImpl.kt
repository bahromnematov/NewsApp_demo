package uz.bahrom.newsapp_demo.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import uz.bahrom.newsapp_demo.presentation.viewmodel.SplashViewModel
import uz.bahrom.newsapp_demo.repository.NewsRepository
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val repository: NewsRepository
) : SplashViewModel, ViewModel() {
    override val navigator = MutableSharedFlow<Unit>()

    init {
        viewModelScope.launch {
            delay(1600)
            navigator.emit(Unit)
        }
    }
}