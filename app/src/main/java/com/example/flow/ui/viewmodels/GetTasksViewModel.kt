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
class GetTasksViewModel @Inject constructor(private val taskDao: NotesDao): ViewModel() {

    fun getTasks(): List<NotesTodo> {
        var taskList: List<NotesTodo> = emptyList()
         viewModelScope.launch(Dispatchers.IO) {
            taskList = taskDao.getNotes() ?: emptyList()
        }
        return taskList
    }
}