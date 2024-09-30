package com.example.flow.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flow.data.dto.Joke
import com.example.flow.ui.viewmodels.JokeViewModel

@Composable
fun JokesScreen() {
    val viewModel: JokeViewModel = hiltViewModel()
    val joke by viewModel.joke.collectAsState()
    Column {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Get Joke")
        }
        LazyColumn {
            items(joke)
            {
                laugh-> CardView(laugh)
            }
        }

    }
}

@Composable
fun CardView(joke: Joke){
Text(text = joke.value)
}