package com.aarh.borutoapp.presentation.screens.search

import androidx.paging.PagingData
import com.aarh.borutoapp.domain.entity.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class SearchState(
    val isLoading: Boolean = false,
    val query: String = "",
    val heroes: Flow<PagingData<Hero>> = emptyFlow(),
)
