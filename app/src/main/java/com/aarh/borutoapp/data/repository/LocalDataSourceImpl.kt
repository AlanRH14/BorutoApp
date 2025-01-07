package com.aarh.borutoapp.data.repository

import com.aarh.borutoapp.data.local.BorutoDatabase
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    borutoDatabase: BorutoDatabase
) : LocalDataSource {
    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelected(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}