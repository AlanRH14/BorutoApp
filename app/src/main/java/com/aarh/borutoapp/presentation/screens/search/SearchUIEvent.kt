package com.aarh.borutoapp.presentation.screens.search

sealed interface SearchUIEvent {
    data class OnSearchClicked(val query: String) : SearchUIEvent
    data class OnUpdateSearchQuery(val query: String) : SearchUIEvent
    data object OnCloseClicked: SearchUIEvent
}