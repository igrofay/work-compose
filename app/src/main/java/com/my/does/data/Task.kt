package com.my.does.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "title_task") var title: String,
    @ColumnInfo(name = "description_task") var description: String,
    @ColumnInfo(name = "demanding_level_task") var demandingLevel : Int,
    @ColumnInfo(name = "done_task")var isDone : Boolean
    )
