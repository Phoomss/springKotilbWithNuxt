package com.example.spring_api.models

data class ResponseModel(
    val status: String,
    val message: String,
    val data: Any? = null
)
