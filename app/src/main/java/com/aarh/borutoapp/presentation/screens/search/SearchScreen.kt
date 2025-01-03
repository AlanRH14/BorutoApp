package com.aarh.borutoapp.presentation.screens.search

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.aarh.borutoapp.presentation.screens.search.components.SearchTopBar

@Composable
fun SearchScreen() {
    Scaffold(
        topBar = {
            SearchTopBar(
                search = "",
                onTextChange = {},
                onSearchClicked = {},
                onClose = {}
            )
        }
    ) { paddingValues ->
    }
}