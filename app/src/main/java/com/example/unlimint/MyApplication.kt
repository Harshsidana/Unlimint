package com.example.unlimint

import android.app.Application
import com.example.unlimint.di.AppModule
import com.example.unlimint.di.NetworkModule
import org.koin.android.ext.koin.androidContext

import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(org.koin.core.logger.Level.DEBUG)
            androidContext(this@MyApplication)
            modules(listOf(AppModule,NetworkModule))
        }
    }
}