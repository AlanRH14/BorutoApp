package com.aarh.borutoapp.presentation.screens.search

sealed interface SearchEffect {
    data class NavigateToDetail(val heroID: Int) : SearchEffect
    data object NavigateToBack : SearchEffect
}