package com.aarh.borutoapp.presentation.screens.search.mvi

sealed interface SearchUIEvent {
    data class OnSearchClicked(val query: String) : SearchUIEvent
    data class OnUpdateSearchQuery(val query: String) : SearchUIEvent
    data class OnHeroItemClicked(val heroID: Int) : SearchUIEvent
    data object OnCloseClicked : SearchUIEvent
}