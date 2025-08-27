package com.aarh.borutoapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreHandle {
    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}
