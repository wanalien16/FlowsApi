package com.example.flow.domain.repository

import com.example.flow.data.dto.Joke

interface JokeRepo {
suspend fun getJoke(): List<Joke>
}