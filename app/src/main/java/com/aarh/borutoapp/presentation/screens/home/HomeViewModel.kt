package com.aarh.borutoapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.aarh.borutoapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {
    val getAllHeroes = useCases.getAllHeroesUseCase()
}
