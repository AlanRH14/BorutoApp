package com.aarh.borutoapp.presentation.screens.detail

sealed class UIEvent {
    data object GenerateColorPalette : UIEvent()
}