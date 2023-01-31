package com.example.tasky.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasky.database.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel (private val repository: TaskRepository) : ViewModel() {

    fun showAllTasks() = viewModelScope.launch {
        repository.getTasks()
    }
}