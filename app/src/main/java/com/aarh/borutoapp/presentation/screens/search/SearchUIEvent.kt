package com.aarh.borutoapp.presentation.screens.search

sealed interface SearchUIEvent {
    data class OnSearchHeroes(val query: String): SearchUIEvent
    data class OnUpdateSearchQuery(val query: String) : SearchUIEvent
}