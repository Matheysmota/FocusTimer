package com.example.focus_timer_poc.Task.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.focus_timer_poc.Task.data.entity.JobEntity

@Database(entities = [JobEntity::class], version = 1)
abstract class TaskDataBase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        private var INSTANCE: TaskDataBase? = null

        fun getInstance(context: Context): TaskDataBase? {
            if (INSTANCE == null) {
                synchronized(TaskDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDataBase::class.java,
                        "task_db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}