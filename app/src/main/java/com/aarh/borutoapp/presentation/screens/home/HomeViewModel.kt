package com.aarh.borutoapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aarh.borutoapp.domain.use_case.UseCases
import com.aarh.borutoapp.presentation.screens.home.mvi.HomeEffect
import com.aarh.borutoapp.presentation.screens.home.mvi.HomeState
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
            is HomeUIEvent.OnHeroItemClicked -> navigateToDetail(heroID = event.heroID)
            is HomeUIEvent.OnSearchClicked -> navigateToSearch()
        }
    }

    private fun getAlHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            _state.update {
                it.copy(
                    heroes = useCases.getAllHeroesUseCase(),
                    isLoading = false,
                )
            }
        }
    }

    private fun navigateToDetail(heroID: Int) {
        viewModelScope.launch {
            _effect.emit(HomeEffect.NavigateToDetail(heroID = heroID))
        }
    }

    private fun navigateToSearch() {
        viewModelScope.launch {
            _effect.emit(HomeEffect.NavigateToSearch)
        }
    }
}
