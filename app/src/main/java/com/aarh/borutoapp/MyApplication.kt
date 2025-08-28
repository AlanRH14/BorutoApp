package com.aarh.borutoapp

import android.app.Application
import com.aarh.borutoapp.di.dataStoreModule
import com.aarh.borutoapp.di.appModule
import com.aarh.borutoapp.di.databaseModule
import com.aarh.borutoapp.di.networkModule
import com.aarh.borutoapp.di.repositoryModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            androidLogger(level = Level.DEBUG)
            modules(
                networkModule,
                databaseModule,
                dataStoreModule,
                repositoryModule,
                appModule
            )
        }
    }
}
