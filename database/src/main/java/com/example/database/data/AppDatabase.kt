package com.example.database.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.domain.models.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}