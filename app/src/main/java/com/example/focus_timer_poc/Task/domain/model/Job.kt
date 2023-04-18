package com.example.focus_timer_poc.Task.domain.model

data class Job(
    val id: Int,
    val jobName: String,
    val jobDescription: String,
    val taskList: List<Task>
)
