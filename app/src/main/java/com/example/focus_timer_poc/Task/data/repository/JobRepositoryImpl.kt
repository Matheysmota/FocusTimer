package com.example.focus_timer_poc.Task.data

import com.example.focus_timer_poc.Task.data.database.JobDao
import com.example.focus_timer_poc.Task.data.entity.JobEntity
import com.example.focus_timer_poc.Task.data.mapper.toJobEntity
import com.example.focus_timer_poc.Task.domain.model.Job
import com.example.focus_timer_poc.Task.domain.repository.JobRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


class JobRepositoryImpl(private val jobDao: JobDao) : JobRepository {

    override fun addJob(job: Job): Completable =
        jobDao.addJob(job.toJobEntity())


    override fun loadJobs(): Single<List<Job>> {
        val jobList = jobDao.loadJobs().map { jobEntity ->
            jobEntity.toDomain()
        }
        return Single.just(jobList)
    }


    override fun removeJob(job: Job): Completable =
        jobDao.deleteJob(job.toJobEntity())


    override fun editJob(job: Job): Single<Job> {
        val myJob = job.toJobEntity()
        return Single.just(jobDao.editJob(myJob).toDomain())
    }
}