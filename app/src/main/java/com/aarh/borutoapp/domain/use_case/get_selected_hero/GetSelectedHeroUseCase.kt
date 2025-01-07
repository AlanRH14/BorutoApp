package com.aarh.borutoapp.domain.use_case.get_selected_hero

import com.aarh.borutoapp.data.repository.Repository
import com.aarh.borutoapp.domain.entity.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}