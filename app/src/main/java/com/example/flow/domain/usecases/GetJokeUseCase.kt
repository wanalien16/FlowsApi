package com.example.flow.domain.usecases

import com.example.flow.data.dto.Joke
import com.example.flow.domain.models.JokeModel
import com.example.flow.domain.repository.JokeRepo
import javax.inject.Inject

class GetJokeUseCase @Inject constructor(private val jokeRepo: JokeRepo){
suspend operator fun invoke(): List<Joke>{
return jokeRepo.getJoke()
}
}