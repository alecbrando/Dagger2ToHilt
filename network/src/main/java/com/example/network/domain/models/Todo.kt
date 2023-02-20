package com.example.network.domain.models



data class Todo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)