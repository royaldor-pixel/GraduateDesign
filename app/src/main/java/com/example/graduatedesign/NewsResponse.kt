package com.example.graduatedesign

data class NewsResponse(
    val `data`: Data,
    val errorCode: Int,
    val errorMsg: String
)