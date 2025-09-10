package com.aarh.borutoapp.presentation.screens.search.mvi

sealed interface SearchEffect {
    data class NavigateToDetail(val heroID: Int) : SearchEffect
    data object NavigateToBack : SearchEffect
}