package com.aarh.borutoapp.presentation.screens.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.aarh.borutoapp.presentation.common.widgets.HeroesListContent
import com.aarh.borutoapp.presentation.screens.search.components.SearchTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = koinViewModel()
) {
    val state by searchViewModel.state.collectAsStateWithLifecycle()
    val heroes = state.heroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SearchTopBar(
                search = state,
                onTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                },
                onSearchClicked = {
                    searchViewModel.searchHeroes(query = it)
                },
                onClose = {
                    navController.popBackStack()
                }
            )
        },
        content = { paddingValues ->
            HeroesListContent(
                modifier = Modifier.padding(paddingValues),
                heroes = heroes,
                onEvent = {
                    //navController
                }
            )
        }
    )
}