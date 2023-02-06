package com.example.tasky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
   @PrimaryKey(autoGenerate = true) val id: Int? = null,
   @ColumnInfo("title")val title: String,
   @ColumnInfo("done")val completed: Boolean,
)
