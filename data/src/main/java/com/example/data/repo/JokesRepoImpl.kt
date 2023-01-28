package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.usecase.repository.JokesRepo

class JokesRepoImpl(private val apiService: ApiService) : JokesRepo {
    override suspend fun getJokes(): String {
        return apiService.getJokes()
    }
}