package com.aarh.borutoapp.presentation.screens.welcome

sealed interface WelcomeEffect {
    data object NavigateToHome: WelcomeEffect
}