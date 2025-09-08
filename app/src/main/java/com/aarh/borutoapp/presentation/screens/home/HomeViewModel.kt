package com.aarh.borutoapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aarh.borutoapp.domain.use_case.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCases: UseCases,
) : ViewModel() {

    fun onEvent(event: HomeUIEvent) {
        when (event) {
            is HomeUIEvent.OnGeAllHeroes -> getAlHeroes()
        }
    }

    private fun getAlHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllHeroesUseCase().collect {

            }
        }
    }

}
