package com.example.flow.data.remote

import com.example.flow.data.dto.Joke
import retrofit2.http.GET

interface ApiService {
    @GET("jokes/random")

    fun getJokes() : List<Joke>

}