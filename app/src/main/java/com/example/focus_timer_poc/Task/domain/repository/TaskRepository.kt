package com.example.focus_timer_poc.Task.domain.repository

import com.example.focus_timer_poc.Task.domain.model.Job
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface JobRepository {
    fun addJob(job: Job): Completable

    fun removeJob(job: Job): Completable

    fun editJob(job: Job): Single<Job>

    fun loadJobs(): Single<List<Job>>
}