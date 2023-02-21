package com.example.database.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val completed: Boolean,
    val title: String,
    val userId: Int
)
