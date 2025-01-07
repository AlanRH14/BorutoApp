package com.aarh.borutoapp.domain.repository

import com.aarh.borutoapp.domain.entity.Hero

interface LocalDataSource {
    suspend fun getSelected(heroId: Int): Hero
}