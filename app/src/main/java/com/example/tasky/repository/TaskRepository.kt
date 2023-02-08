package com.example.tasky.repository

import androidx.room.withTransaction
import com.example.tasky.api.TaskyApi
import com.example.tasky.database.TaskDatabase
import com.example.tasky.model.Task
import com.example.tasky.util.networkBoundResource

class TaskRepository (private val taskyApi: TaskyApi, private val db: TaskDatabase) {

    private val taskdao = db.getTaskDao()

    fun getTasks() = networkBoundResource(
        query = { taskdao.getAllTasks() },
        fetch = { taskyApi.getTodos() },
        saveFetchResult = { task ->
            db.withTransaction {
                task.body()?.let { taskdao.insertTasks(it)}
            }
        }
    )
    fun insert(task: Task) : Unit = taskdao.insertTask(task)

    fun update(task: Task) : Unit = taskdao.update(task)
}