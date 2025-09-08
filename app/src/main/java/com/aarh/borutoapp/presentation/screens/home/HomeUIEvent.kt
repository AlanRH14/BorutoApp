package com.aarh.borutoapp.presentation.screens.home

sealed interface HomeUIEvent {
    data object OnGeAllHeroes: HomeUIEvent
    data class OnClickHeroItem(val heroID: Int): HomeUIEvent
}