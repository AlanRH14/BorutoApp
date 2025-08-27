package com.aarh.borutoapp.domain.use_case.search_heroes

import androidx.paging.PagingData
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: RemoteDataSource
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query = query)
    }
}