package com.example.tasky.database

import com.example.tasky.model.Task
import retrofit2.Response
import retrofit2.http.GET
interface TaskyApi {
    @GET("/todos")
    fun getTodos() : Response<List<Task>>
}