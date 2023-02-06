package com.example.tasky.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasky.model.Task
import com.example.tasky.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel (private val repository: TaskRepository) : ViewModel() {

    private val _taskList = MutableLiveData<List<Task>>()
    val taskList: LiveData<List<Task>> = _taskList

    init {
        viewModelScope.launch(Dispatchers.IO){
            runCatching {
                repository.getTasks()
            }.onSuccess { taskList ->
                _taskList.postValue(taskList.body())
            }
        }
    }
    fun insertTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(task)
    }

    fun updateTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(task)
    }

}