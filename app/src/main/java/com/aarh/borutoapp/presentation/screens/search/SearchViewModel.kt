package com.aarh.borutoapp.presentation.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
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

    private fun onEvent(event: SearchUIEvent) {
        when (event) {
            is SearchUIEvent.OnUpdateSearchQuery -> updateSearchQuery(query = event.query)
            is SearchUIEvent.OnSearchClicked -> searchHeroes(query = event.query)
        }
    }

    private fun updateSearchQuery(query: String) {
        _state.update { it.copy(query = query) }
    }

    private fun searchHeroes(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    heroes = useCases.searchHeroesUseCase.invoke(query).cachedIn(viewModelScope)
                )
            }
        }
    }
}