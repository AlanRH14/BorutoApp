package com.aarh.borutoapp.presentation.screens.welcome

sealed interface WelcomeUIEvent {
    data class OnSaveOnBoardingState(val completed: Boolean) : WelcomeUIEvent
}
