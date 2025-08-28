package com.aarh.borutoapp.domain.use_case.get_all_heroes

import androidx.paging.PagingData
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: RemoteDataSource,
) {

    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}
