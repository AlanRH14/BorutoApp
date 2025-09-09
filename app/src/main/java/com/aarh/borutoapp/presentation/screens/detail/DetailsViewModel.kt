package com.aarh.borutoapp.presentation.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aarh.borutoapp.domain.use_case.UseCases
import com.aarh.borutoapp.presentation.screens.detail.mvi.DetailUIEvent
import com.aarh.borutoapp.presentation.screens.detail.mvi.DetailsEffect
import com.aarh.borutoapp.presentation.screens.detail.mvi.DetailsState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val useCases: UseCases,
) : ViewModel() {

    private val _state = MutableStateFlow(DetailsState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<DetailsEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: DetailUIEvent) {
        when (event) {
            is DetailUIEvent.OnGetSelectedHero -> getSelectedHero(heroID = event.heroID)
            is DetailUIEvent.OnGenerateColorPalette -> generateColorPalette()
            is DetailUIEvent.OnBackClicked -> navigateToBack()
        }
    }

    private fun getSelectedHero(heroID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getSelectedHeroUseCase(heroID = heroID).collect { selectedHero ->
                _state.update {
                    it.copy(
                        isLoading = true,
                        selectedHero = selectedHero
                    )
                }
            }
        }
    }

    private fun generateColorPalette() {
        viewModelScope.launch {
            _effect.emit(DetailsEffect.GenerateColorPalette)
        }
    }

    fun setColorPalette(colors: Map<String, String>) {
        _state.update { it.copy(colorPalette = colors) }
    }

    private fun navigateToBack() {
        viewModelScope.launch {
            _effect.emit(DetailsEffect.NavigateToBack)
        }
    }
}