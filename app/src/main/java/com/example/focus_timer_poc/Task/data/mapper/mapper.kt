package com.example.focus_timer_poc.Task.data.mapper

import com.example.focus_timer_poc.Task.data.entity.JobEntity
import com.example.focus_timer_poc.Task.domain.model.Job

fun Job.toJobEntity(): JobEntity = JobEntity(
    id = this.id,
    jobName = this.jobName ?: "",
    jobDescription = this.jobDescription ?: "",
    taskList = this.taskList ?: listOf()
)