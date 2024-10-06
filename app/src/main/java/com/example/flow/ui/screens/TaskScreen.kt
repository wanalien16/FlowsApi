package com.example.flow.ui.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flow.data.local.NotesTodo
import com.example.flow.ui.viewmodels.GetTasksViewModel

@Composable
fun TaskScreen(onFabClick: () -> Unit){
val viewModel : GetTasksViewModel = hiltViewModel()
    val notes = viewModel.getTasks()
Box(modifier = Modifier.fillMaxSize()) {

    LazyColumn {
items(notes){
    note->
    NoteView(note)
}
    }

    FloatingActionButton(onClick = onFabClick,
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(30.dp),
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Task")

    }
}
}

@Composable
fun NoteView(note: NotesTodo) {
Card {
    Text(text = note.task)
    Spacer(modifier = Modifier.padding(5.dp))
    Text(text = note.description)
}
}
