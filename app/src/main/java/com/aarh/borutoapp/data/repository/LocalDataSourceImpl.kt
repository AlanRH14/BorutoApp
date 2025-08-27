package com.aarh.borutoapp.data.repository

import com.aarh.borutoapp.data.local.dao.HeroDao
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    private val dao: HeroDao
) : LocalDataSource {

    override suspend fun getSelected(heroId: Int): Hero {
        return dao.getSelectedHero(heroId = heroId)
    }
}