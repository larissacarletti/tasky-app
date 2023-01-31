package com.example.tasky.model

data class Task(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)