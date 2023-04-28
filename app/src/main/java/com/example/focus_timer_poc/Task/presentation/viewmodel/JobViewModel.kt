package com.example.focus_timer_poc.Task.presentation.viewmodel

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.focus_timer_poc.Task.domain.model.Job
import com.example.focus_timer_poc.Task.domain.repository.JobRepository
import com.example.focus_timer_poc.Task.domain.usecase.JobUseCases
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import java.lang.Exception

sealed class UiJobState {
    object Loading : UiJobState()

    object Empty : UiJobState()

    data class Success(val jobList: List<Job>) : UiJobState()

    object Error : UiJobState()


}

class JobViewModel(
    private val jobUseCases: JobUseCases,
    private val repository: JobRepository,
    private val IoScheduler: Scheduler,
    private val mainScheduler: Scheduler,
    private val reporter: CrashReporter
    ) : ViewModel() {

    protected val compositeDisposable: CompositeDisposable()
    operator fun CompositeDisposable.plus(disposable: Disposable) = this.add(disposable)

    private val _uiState: MutableLiveData<UiJobState>()
    val state: LiveData<UiJobState> = _uiState

    fun getJobs() {

        compositeDisposable.add(
            jobUseCases.loadJobsUseCase.execute(repository)
                .subscribeOn(IoScheduler)
                .observeOn(mainScheduler)
                .doOnSubscribe { _uiState.value = UiJobState.Loading }
                .subscribe({ jobList ->
                    if (jobList.isEmpty()) {
                        _uiState.value = UiJobState.Empty
                    } else {
                        _uiState.value = UiJobState.Success(jobList)
                    }
                }, {
                    reporter.sendFailureReporter(it)
                    _uiState.value = UiJobState.Error
                })
        )

    }

}

interface CrashReporter {
    fun sendFailureReporter(throwable: Throwable)
}

class CrashReporterImpl ():CrashReporter {
    override fun sendFailureReporter(throwable: Throwable) {
        Log.e(TAG, throwable.toString())
    }

    companion object {
        private const val TAG = "Failure_reporter"
        private const val CONNECTION = "Connection_error"
    }
}