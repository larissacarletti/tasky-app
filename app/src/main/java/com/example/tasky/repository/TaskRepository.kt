package com.example.tasky.repository

import com.example.tasky.api.TaskyApi
import com.example.tasky.database.TaskDao
import com.example.tasky.model.Task
import retrofit2.Response

class TaskRepository (private val taskyApi: TaskyApi, private val taskDao: TaskDao) {

    suspend fun getTasks() : Response<List<Task>> = taskyApi.getTodos()

    suspend fun insert(task: Task) : Unit = taskDao.insert(task)

    suspend fun update(task: Task) : Unit = taskDao.update(task)
}