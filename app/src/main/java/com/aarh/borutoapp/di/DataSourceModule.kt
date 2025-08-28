package com.aarh.borutoapp.di

import androidx.paging.ExperimentalPagingApi
import com.aarh.borutoapp.data.repository.DataStoreHandleImpl
import com.aarh.borutoapp.data.repository.RemoteDataSourceImpl
import com.aarh.borutoapp.domain.repository.DataStoreHandle
import com.aarh.borutoapp.domain.repository.RemoteDataSource
import org.koin.dsl.module

@OptIn(ExperimentalPagingApi::class)
val dataSourceModule = module {

    single<RemoteDataSource> {
        RemoteDataSourceImpl(
            api = get(),
            heroDao = get(),
            heroRemoteKeysDao = get()
        )
    }

    single<DataStoreHandle> { DataStoreHandleImpl(dataStore = get()) }
}