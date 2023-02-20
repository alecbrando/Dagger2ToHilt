package com.example.dagger2tohilt.data.repository

import com.example.dagger2tohilt.domain.repository.Repository
import com.example.network.domain.models.Todo
import com.example.network.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl (private val api: ApiService): Repository {
    override suspend fun getTodo(): Todo = withContext(Dispatchers.IO) {
            api.getTodo()
    }
}