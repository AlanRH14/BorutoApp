package com.aarh.borutoapp.presentation.screens.detail.mvi

sealed interface DetailUIEvent {
    data object OnBackClicked: DetailUIEvent
    data class OnGetSelectedHero(val heroID: Int): DetailUIEvent
}