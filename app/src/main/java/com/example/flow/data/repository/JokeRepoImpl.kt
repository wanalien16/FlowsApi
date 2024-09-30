package com.example.flow.data.repository

import android.util.Log
import com.example.flow.data.dto.Joke
import com.example.flow.data.remote.ApiService
import com.example.flow.domain.repository.JokeRepo
import javax.inject.Inject


class JokeRepoImpl @Inject constructor(private val apiService: ApiService): JokeRepo {
    override suspend fun getJoke(): List<Joke> {
        val response = kotlin.runCatching { apiService.getJokes() }.getOrElse {
            Log.e("error is", "${it.localizedMessage}")
            emptyList()
        }

return response
    }
}



