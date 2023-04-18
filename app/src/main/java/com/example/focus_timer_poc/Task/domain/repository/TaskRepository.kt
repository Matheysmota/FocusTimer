package com.example.focus_timer_poc.Task.domain.repository

import com.example.focus_timer_poc.Task.domain.model.Job

interface TaskRepository {
    suspend fun addTask(task: Job)

    suspend fun removeTask()

    suspend fun editTask()
}