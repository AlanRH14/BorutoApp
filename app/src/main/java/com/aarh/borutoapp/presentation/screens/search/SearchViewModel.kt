package com.aarh.borutoapp.presentation.screens.search

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

class SearchViewModel(
    private val useCases: UseCases,
) : ViewModel() {
    private val _state = MutableStateFlow(SearchState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<SearchEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: SearchUIEvent) {
        when (event) {
            is SearchUIEvent.OnUpdateSearchQuery -> updateSearchQuery(query = event.query)
            is SearchUIEvent.OnSearchClicked -> searchHeroes(query = event.query)
            is SearchUIEvent.OnHeroItemClicked -> navigateToDetail(heroID = event.heroID)
            is SearchUIEvent.OnCloseClicked -> navigateToBack()
        }
    }

    private fun updateSearchQuery(query: String) {
        _state.update { it.copy(query = query) }
    }

    private fun searchHeroes(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    heroes = useCases.searchHeroesUseCase.invoke(query)
                )
            }
        }
    }

    private fun navigateToDetail(heroID: Int) {
        viewModelScope.launch {
            _effect.emit(SearchEffect.NavigateToDetail(heroID = heroID))
        }
    }

    private fun navigateToBack() {
        viewModelScope.launch {
            _effect.emit(SearchEffect.NavigateToBack)
        }
    }
}