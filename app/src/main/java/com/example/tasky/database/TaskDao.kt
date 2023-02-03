package com.example.tasky.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tasky.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //CASO DER ERRO, VOLTAR AQUI
   suspend fun insert(task: List<Task>)

    @Query("SELECT * FROM task_table")
   fun getAllTasks():Flow<List<Task>>

}