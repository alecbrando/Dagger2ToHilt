package com.example.network.remote

import com.example.network.domain.models.Todo
import retrofit2.http.GET

interface  ApiService{
    @GET("/todos/1")
    suspend fun getTodo(): Todo
}