package com.example.focus_timer_poc.Task.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.focus_timer_poc.Task.data.entity.JobEntity

@Database(entities = [JobEntity::class], version = 1)
abstract class JobDataBase : RoomDatabase() {

    abstract fun JobDao(): JobDao

    companion object {
        private var INSTANCE: JobDataBase? = null

        fun getInstance(context: Context): JobDataBase? {
            if (INSTANCE == null) {
                synchronized(JobDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        JobDataBase::class.java,
                        "Job_db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}