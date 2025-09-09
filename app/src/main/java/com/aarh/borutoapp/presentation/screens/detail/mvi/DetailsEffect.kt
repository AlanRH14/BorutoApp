package com.aarh.borutoapp.presentation.screens.detail.mvi

sealed interface DetailsEffect {
    data object GenerateColorPalette : DetailsEffect
    data object NavigateToBack : DetailsEffect
}