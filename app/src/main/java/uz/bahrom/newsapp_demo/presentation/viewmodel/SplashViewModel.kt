package uz.bahrom.newsapp_demo.presentation.viewmodel

import kotlinx.coroutines.flow.SharedFlow

interface SplashViewModel {

    val navigator: SharedFlow<Unit>
}