package com.example.dagger2tohilt.domain.repository

import com.example.network.domain.models.Todo

interface Repository {
    suspend fun getTodo(): Todo
}