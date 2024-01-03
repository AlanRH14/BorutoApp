package com.aarh.borutoapp.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.aarh.borutoapp.presentation.common.widgets.HeroesListContent
import com.aarh.borutoapp.presentation.screens.home.components.HomeTopBar

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar {}
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues),
            ) {
                HeroesListContent(
                    navController = navController,
                    heroes = allHeroes
                )
            }
        },
    )
}
