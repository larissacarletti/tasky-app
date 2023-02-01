package com.example.tasky.api

import com.example.tasky.model.Task
import retrofit2.Response
import retrofit2.http.GET

interface TaskyApi {
    @GET("/todos")
    suspend fun getTodos() : Response<List<Task>>
}