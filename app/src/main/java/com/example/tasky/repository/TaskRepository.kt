package com.example.tasky.repository

import com.example.tasky.api.TaskyApi
import com.example.tasky.model.Task
import retrofit2.Response

class TaskRepository (private val taskyApi: TaskyApi) {

    suspend fun getTasks() : Response<List<Task>> = taskyApi.getTodos()

    //suspend fun insert(task: Task) : Response<List<Task>> = taskyApi.insert()
}