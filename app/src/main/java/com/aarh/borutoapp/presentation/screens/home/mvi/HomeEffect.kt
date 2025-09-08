package com.aarh.borutoapp.presentation.screens.home.mvi

sealed interface HomeEffect {
    data class NavigateToDetail(val heroID: Int) : HomeEffect

    data object NavigateToSearch : HomeEffect
}