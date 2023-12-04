package com.aarh.borutoapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.aarh.borutoapp.domain.use_case.UseCases
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    val getAllHeroes = useCases.getAllHeroesUseCase()
}
