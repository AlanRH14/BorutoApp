package com.aarh.borutoapp.presentation.common.widgets

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import com.aarh.borutoapp.domain.entity.Hero

@Composable
fun HeroesListContent(
    navController: NavHostController,
    heroes: LazyPagingItems<Hero>
) {
}