package com.example.flow.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flow.data.dto.Joke
import com.example.flow.domain.usecases.GetJokeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(private val getJokeUseCase: GetJokeUseCase) : ViewModel() {

    private val _joke = MutableStateFlow<List<Joke>>(emptyList())
    val joke: StateFlow<List<Joke>> = _joke.asStateFlow()

    init {
        fetchJoke()
    }

    private fun fetchJoke() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val response = getJokeUseCase()
                viewModelScope.launch { _joke.value = response }
            }.getOrElse { Log.e("error is", it.localizedMessage) }
        }
    }

}