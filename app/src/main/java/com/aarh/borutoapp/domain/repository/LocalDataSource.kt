package com.aarh.borutoapp.domain.repository

import com.aarh.borutoapp.domain.entity.Hero
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getSelected(heroID: Int): Flow<Hero>
}