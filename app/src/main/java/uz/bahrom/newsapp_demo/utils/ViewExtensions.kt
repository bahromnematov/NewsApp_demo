package uz.bahrom.newsapp_demo.utils

import android.view.View

// Created by Jamshid Isoqov an 10/9/2022


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.inVisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

