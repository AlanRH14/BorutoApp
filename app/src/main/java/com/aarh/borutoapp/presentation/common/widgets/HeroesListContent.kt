package com.aarh.borutoapp.presentation.common.widgets

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.presentation.common.components.HeroItem
import com.aarh.borutoapp.ui.theme.SMALL_PADDING

@Composable
fun HeroesListContent(
    navController: NavHostController,
    heroes: LazyPagingItems<Hero>,
) {
    Log.d("ListContent", "${heroes.loadState}")
    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING),
    ) {
        items(
            count = heroes.itemCount,
            key = heroes.itemKey { hero -> hero.id },
        ) { index ->
            heroes[index]?.let { hero -> HeroItem(navController = navController, hero = hero) }
        }
    }
}
