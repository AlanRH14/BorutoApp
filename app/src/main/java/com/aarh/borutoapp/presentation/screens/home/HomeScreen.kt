package com.aarh.borutoapp.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.aarh.borutoapp.navigation.Details
import com.aarh.borutoapp.navigation.NavRoutes
import com.aarh.borutoapp.navigation.Search
import com.aarh.borutoapp.presentation.common.widgets.HeroesListContent
import com.aarh.borutoapp.presentation.screens.home.components.HomeTopBar
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = koinViewModel(),
) {
    val state by homeViewModel.state.collectAsState()
    val heroes = state.heroes.collectAsLazyPagingItems()

    LaunchedEffect(key1 = true) {
        homeViewModel.onEvent(HomeUIEvent.OnGeAllHeroes)
        homeViewModel.effect.collectLatest { effect ->
            when (effect) {
                is HomeEffect.NavigateToDetail -> {
                    navController.navigate(Details(heroID = effect.heroID))
                }
            }
        }
    }

    Scaffold(
        topBar = {
            HomeTopBar {
                navController.navigate(Search)
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues),
            ) {
                HeroesListContent(
                    heroes = heroes,
                    onEvent = homeViewModel::onEvent
                )
            }
        },
    )
}
