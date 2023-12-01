package com.aarh.borutoapp.domain.use_case.get_all_heroes

import androidx.paging.PagingData
import com.aarh.borutoapp.data.repository.Repository
import com.aarh.borutoapp.domain.entity.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository,
) {

    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}
