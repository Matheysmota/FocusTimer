package com.example.focus_timer_poc.Task.data

import com.example.focus_timer_poc.Task.data.database.JobDao
import com.example.focus_timer_poc.Task.data.entity.JobEntity
import com.example.focus_timer_poc.Task.data.mapper.toJobEntity
import com.example.focus_timer_poc.Task.domain.model.Job
import com.example.focus_timer_poc.Task.domain.repository.JobRepository


class JobRepositoryImpl(private val jobDao: JobDao): JobRepository {

    override suspend fun addJob(job: Job) =
        jobDao.addJob(job.toJobEntity())


    override suspend fun loadJobs(): List<Job> =
        jobDao.loadJobs().map { jobEntity ->
            jobEntity.toDomain()
        }


    override suspend fun removeJob(job: Job) =
        jobDao.deleteJob(job.toJobEntity())


    override suspend fun editJob(job: Job): Job {
        val myJob = job.toJobEntity()
        return jobDao.editJob(myJob).toDomain()
    }
}