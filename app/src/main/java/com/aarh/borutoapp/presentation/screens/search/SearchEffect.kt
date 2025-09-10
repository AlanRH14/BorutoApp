package com.aarh.borutoapp.presentation.screens.search

sealed interface SearchEffect {
    data object NavigateToBack : SearchEffect
}