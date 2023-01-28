package com.example.unlimint.di

import com.example.unlimint.viewmodel.JokesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val AppModule = module {
    viewModel { JokesViewModel(get()) }
    single { createJokesRepo(get()) }
    single { createJokesUseCase(get()) }
}