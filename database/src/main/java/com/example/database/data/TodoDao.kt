package com.example.database.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.database.domain.models.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos")
    fun getAll(): List<Todo>

    @Insert
    fun insert(todo: Todo)
}