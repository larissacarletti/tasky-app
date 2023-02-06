package com.example.tasky.database

import androidx.room.*
import com.example.tasky.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(task: Task)

   @Query("SELECT * FROM task_table")
   fun getAllTasks():Flow<List<Task>>

   @Update
   fun update(task: Task)

}