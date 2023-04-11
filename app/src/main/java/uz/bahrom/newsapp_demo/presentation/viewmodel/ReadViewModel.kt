package uz.bahrom.newsapp_demo.presentation.viewmodel

import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity

interface ReadViewModel {

fun  updateNews(newsEntity: NewsEntity)
}