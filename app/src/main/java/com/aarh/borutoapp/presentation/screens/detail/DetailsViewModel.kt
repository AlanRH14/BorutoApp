package com.aarh.borutoapp.presentation.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.domain.use_case.UseCases
import com.aarh.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _selectedHero: MutableStateFlow<Hero?> = MutableStateFlow(null)
    val selectedHero: StateFlow<Hero?> get() = _selectedHero

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val heroId = savedStateHandle.get<Int>(DETAILS_ARGUMENT_KEY)
            _selectedHero.value = heroId?.let { id ->  useCases.getSelectedHeroUseCase(heroId = id)}
        }
    }
}