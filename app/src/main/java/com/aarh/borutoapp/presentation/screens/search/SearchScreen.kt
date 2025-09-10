package com.aarh.borutoapp.presentation.screens.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.aarh.borutoapp.navigation.Details
import com.aarh.borutoapp.presentation.common.widgets.HeroesListContent
import com.aarh.borutoapp.presentation.screens.home.mvi.HomeUIEvent
import com.aarh.borutoapp.presentation.screens.search.components.SearchTopBar
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = koinViewModel()
) {
    val state by searchViewModel.state.collectAsStateWithLifecycle()
    val heroes = state.heroes.collectAsLazyPagingItems()

    LaunchedEffect(key1 = true) {
        searchViewModel.effect.collectLatest { effect ->
            when (effect) {
                is SearchEffect.NavigateToDetail -> navController.navigate(Details(heroID = effect.heroID))

                is SearchEffect.NavigateToBack -> navController.popBackStack()
            }
        }
    }

    Scaffold(
        topBar = {
            SearchTopBar(
                search = state.query,
                onEvent = searchViewModel::onEvent
            )
        },
        content = { paddingValues ->
            HeroesListContent(
                modifier = Modifier.padding(paddingValues),
                heroes = heroes,
                onEvent = {
                    when (it) {
                        is HomeUIEvent.OnHeroItemClicked -> {
                            searchViewModel.onEvent(SearchUIEvent.OnHeroItemClicked(it.heroID))
                        }

                        else -> Unit
                    }
                }
            )
        }
    )
}