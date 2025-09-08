package com.aarh.borutoapp.domain.use_case.get_selected_hero

import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow

class GetSelectedHeroUseCase(
    private val repository: LocalDataSource
) {
    operator fun invoke(heroID: Int): Flow<Hero> {
        return repository.getSelected(heroID = heroID)
    }
}