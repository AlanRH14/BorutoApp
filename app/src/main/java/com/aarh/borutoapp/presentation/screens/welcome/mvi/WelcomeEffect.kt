package com.aarh.borutoapp.presentation.screens.welcome.mvi

sealed interface WelcomeEffect {
    data object NavigateToHome: WelcomeEffect
}