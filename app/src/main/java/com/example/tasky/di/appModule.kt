package com.example.tasky.di

import com.example.tasky.api.TaskyApi
import com.example.tasky.database.TaskDatabase
import com.example.tasky.repository.TaskRepository
import com.example.tasky.viewmodel.TaskViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                    ).build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TaskyApi::class.java)
    }
    single { TaskRepository(get()) }

    viewModel {TaskViewModel(get()) }

    //single { TaskDatabase(get()) }
}