package com.aarh.borutoapp.di

import androidx.room.Room
import com.aarh.borutoapp.data.local.BorutoDatabase
import com.aarh.borutoapp.data.repository.LocalDataSourceImpl
import com.aarh.borutoapp.util.Constants.BORUTO_DATABASE
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            BorutoDatabase::class.java,
            BORUTO_DATABASE,
        ).build()
    }

    single { get<BorutoDatabase>().heroDao() }

    single { get<BorutoDatabase>().heroRemoteKeysDao() }
}
