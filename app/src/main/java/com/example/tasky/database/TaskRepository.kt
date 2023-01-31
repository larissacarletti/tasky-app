package com.example.tasky.database

import com.example.tasky.model.Task
import retrofit2.Response

class TaskRepository (private val taskyApi: TaskyApi) {

    fun getTasks() : Response<List<Task>> = taskyApi.getTodos()

}