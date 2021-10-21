package com.my.does.data

import androidx.room.Room
import com.my.does.feature.app.App

object WorkWithDB {
    private val db by lazy {
        Room.databaseBuilder(
            App.appContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
    val taskDao by lazy {
        db.taskDao()
    }
}