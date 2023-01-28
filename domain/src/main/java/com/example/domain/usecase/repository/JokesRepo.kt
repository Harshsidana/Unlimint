package com.example.domain.usecase.repository

interface JokesRepo {

    suspend fun getJokes(): String
}