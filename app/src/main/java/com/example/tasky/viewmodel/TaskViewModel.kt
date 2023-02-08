package com.example.tasky.viewmodel

import androidx.lifecycle.*
import com.example.tasky.model.Task
import com.example.tasky.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel (private val repository: TaskRepository) : ViewModel() {

    val taskList = repository.getTasks().asLiveData()

    fun insertTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(task)
    }

    fun updateTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(task)
    }

}