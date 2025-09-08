package com.aarh.borutoapp.presentation.screens.home

import com.aarh.borutoapp.domain.entity.Hero

data class HomeState(
    val isLoading: Boolean = false,
    val heroes: List<Hero> = emptyList(),
)
