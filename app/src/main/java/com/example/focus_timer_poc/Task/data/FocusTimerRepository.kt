package com.example.focus_timer_poc.Task.data

import com.example.focus_timer_poc.Task.data.database.TaskDao
import com.example.focus_timer_poc.Task.data.mapper.toJobEntity
import com.example.focus_timer_poc.Task.domain.model.Job
import com.example.focus_timer_poc.Task.domain.repository.TaskRepository

class TaskRepositoryImpl(private val taskDao: TaskDao): TaskRepository {
    override suspend fun addTask(task: Job) {
        taskDao.addTask(task.toJobEntity())
    }

    override suspend fun removeTask() {
        TODO("Not yet implemented")
    }

    override suspend fun editTask() {
        TODO("Not yet implemented")
    }

}