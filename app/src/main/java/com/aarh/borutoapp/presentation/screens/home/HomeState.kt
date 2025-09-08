package com.aarh.borutoapp.presentation.screens.home

import androidx.paging.PagingData
import com.aarh.borutoapp.domain.entity.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class HomeState(
    val isLoading: Boolean = false,
    val heroes: Flow<PagingData<Hero>> = emptyFlow(),
)
