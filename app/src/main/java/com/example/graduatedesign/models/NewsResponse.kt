package com.example.graduatedesign.models

data class NewsResponse(
    val `data`: Data,
    val errorCode: Int,
    val errorMsg: String
)