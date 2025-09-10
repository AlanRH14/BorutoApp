package com.aarh.borutoapp.presentation.screens.detail.mvi

sealed interface DetailsUIEvent {
    data class OnGetSelectedHero(val heroID: Int) : DetailsUIEvent
    data object OnGenerateColorPalette : DetailsUIEvent
    data class OnSetColorPalette(val colors: Map<String, String>): DetailsUIEvent
    data object OnBackClicked : DetailsUIEvent
}