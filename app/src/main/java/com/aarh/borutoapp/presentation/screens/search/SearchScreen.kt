package com.aarh.borutoapp.presentation.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aarh.borutoapp.presentation.screens.search.components.SearchTopBar

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            SearchTopBar(
                search = "",
                onTextChange = {},
                onSearchClicked = {},
                onClose = {}
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {

            }
        }
    )
}