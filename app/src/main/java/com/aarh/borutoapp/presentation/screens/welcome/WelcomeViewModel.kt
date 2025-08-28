package com.aarh.borutoapp.presentation.screens.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aarh.borutoapp.domain.use_case.UseCases
import com.aarh.borutoapp.presentation.screens.welcome.mvi.WelcomeEffect
import com.aarh.borutoapp.presentation.screens.welcome.mvi.WelcomeUIEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val useCases: UseCases,
) : ViewModel() {
    private val _effect = MutableSharedFlow<WelcomeEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: WelcomeUIEvent) {
        when (event) {
            is WelcomeUIEvent.OnSaveOnBoardingState -> saveOnBoardingState(completed = event.completed)
            is WelcomeUIEvent.OnNavigateToHome -> navigateToHome()
        }
    }

    private fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.saveOnBoardingUseCase(completed = completed)
        }
    }

    private fun navigateToHome() {
        viewModelScope.launch {
            _effect.emit(WelcomeEffect.NavigateToHome)
        }
    }
}
