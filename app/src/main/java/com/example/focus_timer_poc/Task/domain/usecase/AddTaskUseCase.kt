package com.example.focus_timer_poc.Task.domain.usecase

import com.example.focus_timer_poc.Task.domain.model.Job
import com.example.focus_timer_poc.Task.domain.repository.TaskRepository

class AddTaskUseCase(private val repository: TaskRepository) {
    suspend fun execute(task: Job) = repository.addTask(task)
}