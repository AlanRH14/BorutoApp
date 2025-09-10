package com.aarh.borutoapp.presentation.screens.search

import androidx.paging.PagingData
import com.aarh.borutoapp.domain.entity.Hero

data class SearchState(
    val isLoading: Boolean = false,
    val query: String = "",
    val heroes: PagingData<Hero> = PagingData.empty(),
)
