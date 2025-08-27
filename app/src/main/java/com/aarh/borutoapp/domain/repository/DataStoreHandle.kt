package com.aarh.borutoapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreHandle {
    suspend fun <T> saveState(key: PreferencesKey<T>, value: T)
    fun <T> readState(): Flow<T>
}
