package com.aarh.borutoapp.presentation.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.use_case.UseCases
import com.aarh.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _selectedHero: MutableStateFlow<Hero?> = MutableStateFlow(null)
    val selectedHero: StateFlow<Hero?> get() = _selectedHero
    private val _uiEvent = MutableSharedFlow<UIEvent>()
    val uiEvent: SharedFlow<UIEvent> get() = _uiEvent.asSharedFlow()
    private val _colorPalette: MutableStateFlow<Map<String, String>> = MutableStateFlow(mapOf())
    val colorPalette: StateFlow<Map<String, String>> get() = _colorPalette

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val heroId = savedStateHandle.get<Int>(DETAILS_ARGUMENT_KEY)
            _selectedHero.value = heroId?.let { id -> useCases.getSelectedHeroUseCase(heroId = id) }
        }
    }

    fun generateColorPalette() {
        viewModelScope.launch {
            _uiEvent.emit(UIEvent.GenerateColorPalette)
        }
    }

    fun setColorPalette(colors: Map<String, String>) {
        _colorPalette.value = colors
    }
}