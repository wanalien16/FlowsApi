package com.example.flow.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddTaskScreen() {
    var taskName by remember { mutableStateOf("") }
    var taskDescription by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()
    ) {

        Text(text = "Task Name")
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(value = taskName, onValueChange = { taskName = it })
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Description")
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(value = taskDescription, onValueChange = { taskDescription = it })
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Save")
        }

    }


}

        

