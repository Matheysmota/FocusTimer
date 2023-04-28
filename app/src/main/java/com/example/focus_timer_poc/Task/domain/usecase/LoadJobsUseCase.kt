package com.example.focus_timer_poc.Task.domain.usecase

import com.example.focus_timer_poc.Task.domain.model.Job
import com.example.focus_timer_poc.Task.domain.repository.JobRepository
import io.reactivex.rxjava3.core.Single

class LoadJobsUseCase(private val repository: JobRepository) {

    fun execute(repository: JobRepository): Single<List<Job>> =
        repository.loadJobs()
}