package uz.bahrom.newsapp_demo.utils


fun Throwable.getMessage() = this.message ?: "Unknown error"