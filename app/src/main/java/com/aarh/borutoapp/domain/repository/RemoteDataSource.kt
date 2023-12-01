package com.aarh.borutoapp.domain.repository

import androidx.paging.PagingData
import com.aarh.borutoapp.domain.entity.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(): Flow<PagingData<Hero>>
}
