package com.example.tasky.repository

import androidx.room.withTransaction
import com.example.tasky.api.TaskyApi
import com.example.tasky.database.TaskDao
import com.example.tasky.database.TaskDatabase
import com.example.tasky.model.Task
import com.example.tasky.util.networkBoundResource
import retrofit2.Response

class TaskRepository (private val taskyApi: TaskyApi, private val db: TaskDatabase) {

    private val taskdao = db.getTaskDao()

    fun getTodos() = networkBoundResource(
        query = {
            taskdao.getAllTasks()
        },
        fetch = {
            taskyApi.getTodos()
        },
        saveFetchResult = { task ->
            db.withTransaction {
                taskdao.insert(task)
            }

        }

    )





//    suspend fun getTasks() : Response<List<Task>> = taskyApi.getTodos()
//
//    suspend fun insert(task: Task) : Unit = taskDao.insert(task)
//
//    fun update(task: Task) : Unit = taskDao.update(task)
}