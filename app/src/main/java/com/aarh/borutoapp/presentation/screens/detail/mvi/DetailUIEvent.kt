package com.aarh.borutoapp.presentation.screens.detail.mvi

sealed interface DetailUIEvent {
    data class OnGetSelectedHero(val heroID: Int) : DetailUIEvent
    data object OnGenerateColorPalette : DetailUIEvent
    data class OnSetColorPalette(val colors: Map<String, String>): DetailUIEvent
    data object OnBackClicked : DetailUIEvent
}