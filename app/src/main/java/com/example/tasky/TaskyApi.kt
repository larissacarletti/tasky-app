package com.example.tasky

import retrofit2.Response
import retrofit2.http.GET


interface TaskyApi {

    @GET("/todos")
    suspend fun getTodos() : Response<List<Todo>>

}