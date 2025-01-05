package com.aarh.borutoapp.presentation.screens.search

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.aarh.borutoapp.presentation.screens.search.components.SearchTopBar

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            SearchTopBar(
                search = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(it)
                },
                onSearchClicked = {},
                onClose = {
                    navController.popBackStack()
                }
            )
        },
        content = { paddingValues ->

        }
    )
}