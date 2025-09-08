package com.aarh.borutoapp.presentation.screens.home.components

sealed interface HomeEffect {
    data class NavigateToDetail(val heroID: Int) : HomeEffect

    data object NavigateToSearch : HomeEffect
}