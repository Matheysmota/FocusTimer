package com.example.focus_timer_poc.Task.domain.usecase

data class JobUseCases(
    val addJobUseCase: AddJobUseCase,
    val editJobUseCase: EditJobUseCase,
    val removeJobUseCase: RemoveJobUseCase,
    val loadJobsUseCase: LoadJobsUseCase
)