package com.aarh.borutoapp.presentation.common.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.presentation.common.components.HeroItem
import com.aarh.borutoapp.ui.theme.SMALL_PADDING
import com.aarh.borutoapp.presentation.screens.error.handlerPagingResult

@Composable
fun HeroesListContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    heroes: LazyPagingItems<Hero>,
) {
    val result = handlerPagingResult(heroes = heroes)
    if (result) {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(all = SMALL_PADDING),
            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING),
        ) {
            items(
                count = heroes.itemCount,
                key = heroes.itemKey { hero ->
                    hero.id
                },
            ) { index ->
                heroes[index]?.let { hero ->
                    HeroItem(
                        navController = navController,
                        hero = hero,
                    )
                }
            }
        }
    }
}
