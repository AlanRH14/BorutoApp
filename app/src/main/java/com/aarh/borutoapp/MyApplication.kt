package com.aarh.borutoapp

import android.app.Application
import com.aarh.borutoapp.di.databaseModule
import com.aarh.borutoapp.di.networkModule
import com.aarh.borutoapp.di.repositoryModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.core.context.startKoin

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                networkModule,
                databaseModule,
                databaseModule,
                repositoryModule,
            )
        }
    }
}
