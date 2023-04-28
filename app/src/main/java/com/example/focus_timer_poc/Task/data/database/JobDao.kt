package com.example.focus_timer_poc.Task.data.database

import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Update
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.focus_timer_poc.Task.data.entity.JobEntity
import io.reactivex.rxjava3.core.Completable

interface JobDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addJob(job: JobEntity): Completable

    @Delete
    fun deleteJob(job: JobEntity): Completable

    @Update
    fun editJob(job: JobEntity): JobEntity

    @Query("SELECT * FROM JobEntity")
    fun loadJobs(): List<JobEntity>
}