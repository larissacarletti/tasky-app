package com.example.tasky.database

import androidx.room.*
import com.example.tasky.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun insertTasks(task: List<Task>)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun insertTask(task: Task)

   @Update
   fun update(task: Task)

   @Query("SELECT * FROM task_table order by id DESC")
   fun getAllTasks():Flow<List<Task>>

   @Query("DELETE FROM task_table WHERE done = 1")
   suspend fun deleteAll()

}