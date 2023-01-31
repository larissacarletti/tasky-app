package com.example.tasky.utilities

import com.example.tasky.database.TaskyApi
import com.example.tasky.database.TaskRepository
import com.example.tasky.model.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TaskyApi::class.java)
    }
    single {
        TaskRepository(get())
    }
    viewModel {
        TaskViewModel(get())
    }



}