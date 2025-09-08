package com.aarh.borutoapp.presentation.screens.home

sealed interface HomeEffect {
    data class NavigateToDetail(val heroID: Int) : HomeEffect

    data object NavigateToSearch : HomeEffect
}