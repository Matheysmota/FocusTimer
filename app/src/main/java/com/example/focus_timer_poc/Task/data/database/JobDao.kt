package com.example.focus_timer_poc.Task.data.database

import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Update
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.focus_timer_poc.Task.data.entity.JobEntity

interface JobDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJob(job: JobEntity)

    @Delete
    suspend fun deleteJob(job: JobEntity)

    @Update
    suspend fun editJob(job: JobEntity): JobEntity

    @Query("SELECT * FROM JobEntity")
    suspend fun loadJobs(): List<JobEntity>
}