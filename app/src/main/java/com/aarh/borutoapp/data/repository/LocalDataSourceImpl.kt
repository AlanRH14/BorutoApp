package com.aarh.borutoapp.data.repository

import com.aarh.borutoapp.data.local.dao.HeroDao
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalDataSourceImpl(
    private val dao: HeroDao
) : LocalDataSource {

    override fun getSelected(heroID: Int): Flow<Hero>  = flow {
        emit(dao.getSelectedHero(heroId = heroID))
    }
}