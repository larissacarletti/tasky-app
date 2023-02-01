package com.example.tasky.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasky.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel (private val repository: TaskRepository) : ViewModel() {

    fun showAllTasks() = viewModelScope.launch(Dispatchers.IO){
        repository.getTasks()
    }
}