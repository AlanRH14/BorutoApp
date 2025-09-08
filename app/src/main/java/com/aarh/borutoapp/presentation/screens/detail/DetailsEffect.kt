package com.aarh.borutoapp.presentation.screens.detail

sealed interface DetailsEffect {
    data object NavigateToBack : DetailsEffect
}