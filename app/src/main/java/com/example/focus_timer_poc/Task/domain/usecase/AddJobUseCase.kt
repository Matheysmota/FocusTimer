package com.example.focus_timer_poc.Task.domain.usecase

import com.example.focus_timer_poc.Task.domain.model.Job
import com.example.focus_timer_poc.Task.domain.repository.JobRepository

class AddJobUseCase(private val repository: JobRepository) {
    suspend fun execute(Job: Job) = repository.addJob(Job)
}