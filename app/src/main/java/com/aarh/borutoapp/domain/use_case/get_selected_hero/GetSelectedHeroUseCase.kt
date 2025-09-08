package com.aarh.borutoapp.domain.use_case.get_selected_hero

import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.repository.LocalDataSource

class GetSelectedHeroUseCase(
    private val repository: LocalDataSource
) {
    suspend operator fun invoke(heroID: Int): Hero {
        return repository.getSelected(heroId = heroID)
    }
}