package com.aarh.borutoapp.presentation.screens.welcome.mvi

sealed interface WelcomeUIEvent {
    data class OnSaveOnBoardingState(val completed: Boolean) : WelcomeUIEvent
    data object OnNavigateToHome: WelcomeUIEvent
}