package com.example.flow.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flow.data.local.NotesDao
import com.example.flow.data.local.NotesTodo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AddTaskViewModel @Inject constructor(private val taskDao: NotesDao) : ViewModel(){
fun insertTask(taskName: String, taskDescription: String){
    viewModelScope.launch(Dispatchers.IO) {
        taskDao.insertNote(note = NotesTodo(id = 1, task = taskName, description = taskDescription))
    }

}
}