package com.example.domain.repository

interface JokesRepo {

    suspend fun getJokes(): String
}