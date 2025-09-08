package com.aarh.borutoapp.presentation.screens.home

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aarh.borutoapp.domain.use_case.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCases: UseCases,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<HomeEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: HomeUIEvent) {
        when (event) {
            is HomeUIEvent.OnGeAllHeroes -> getAlHeroes()
        }
    }

    private fun getAlHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            useCases.getAllHeroesUseCase().collect { heroes ->

                _state.update {
                    it.copy(
                        isLoading = false,
                        heroes = heroes
                    )
                }
            }
        }
    }
}
