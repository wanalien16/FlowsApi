package com.example.flow.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Joke(val categories: String,
    val createdAt : String,
    val iconUrl: String,
    val id: String,
    val updatedAt: String,
    val url: String,
    val value: String
    )
