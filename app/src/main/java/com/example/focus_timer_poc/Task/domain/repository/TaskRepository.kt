package com.example.focus_timer_poc.Task.domain.repository

import com.example.focus_timer_poc.Task.domain.model.Job

interface JobRepository {
    suspend fun addJob(job: Job)

    suspend fun removeJob(job: Job)

    suspend fun editJob(job: Job): Job

    suspend fun loadJobs(): List<Job>
}