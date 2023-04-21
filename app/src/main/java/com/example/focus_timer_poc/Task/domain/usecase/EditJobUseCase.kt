package com.example.focus_timer_poc.Task.domain.usecase

import com.example.focus_timer_poc.Task.domain.model.Job
import com.example.focus_timer_poc.Task.domain.repository.JobRepository

class EditJobUseCase(private val repository: JobRepository) {

    suspend fun execute(repository: JobRepository, job: Job) =
        repository.editJob(job)
}