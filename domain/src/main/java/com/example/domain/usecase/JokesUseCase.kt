package com.example.domain.usecase

import com.example.domain.usecase.base.BaseUseCase
import com.example.domain.usecase.repository.JokesRepo

class JokesUseCase constructor(
    private val jokesRepo: JokesRepo
) : BaseUseCase<String>() {

    override suspend fun run(): String {
        return jokesRepo.getJokes()
    }

}