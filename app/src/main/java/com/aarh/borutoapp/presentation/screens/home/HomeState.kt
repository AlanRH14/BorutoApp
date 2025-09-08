package com.aarh.borutoapp.presentation.screens.home

import androidx.paging.PagingData
import com.aarh.borutoapp.domain.entity.Hero

data class HomeState(
    val isLoading: Boolean = false,
    val heroes: PagingData<Hero> = PagingData.empty(),
)
