package com.example.focus_timer_poc.Task.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.focus_timer_poc.Task.domain.model.Job
import com.example.focus_timer_poc.Task.domain.model.Task

@Entity
data class JobEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "job_name") val jobName: String?,
    @ColumnInfo(name = "job_description") val jobDescription: String?,
    @ColumnInfo(name = "job_progress") val taskList: List<Task>
) {
    fun toDomain(): Job =
        Job(
            id = this.id,
            jobName = this.jobName ?: "",
            jobDescription = this.jobDescription ?: "",
            taskList = this.taskList
        )
}