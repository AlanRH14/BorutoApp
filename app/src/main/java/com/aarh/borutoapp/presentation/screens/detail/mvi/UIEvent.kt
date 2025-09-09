package com.aarh.borutoapp.presentation.screens.detail.mvi

sealed class UIEvent {
    data object GenerateColorPalette : UIEvent()
}