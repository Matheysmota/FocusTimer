package com.example.focus_timer_poc.Task.data.database

import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Update
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.focus_timer_poc.Task.data.entity.JobEntity

interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: JobEntity)

    @Delete
    suspend fun deleteTask(task: JobEntity)

    @Update
    suspend fun editTask(task: JobEntity): JobEntity

    @Query("SELECT * FROM taskEntity")
    suspend fun loadTasks(): List<JobEntity>
}