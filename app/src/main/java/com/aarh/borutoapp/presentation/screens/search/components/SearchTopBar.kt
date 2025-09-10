package com.aarh.borutoapp.presentation.screens.search.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.room.util.query
import com.aarh.borutoapp.presentation.screens.search.SearchUIEvent
import com.aarh.borutoapp.presentation.screens.search.widgets.SearchWidget

@Composable
fun SearchTopBar(
    modifier: Modifier = Modifier,
    search: String,
    onEvent: (SearchUIEvent) -> Unit,
) {
    SearchWidget(
        modifier = modifier,
        text = search,
        onTextChange = { onEvent(SearchUIEvent.OnUpdateSearchQuery(query = it)) },
        onSearchClicked = { onEvent(SearchUIEvent.OnSearchClicked(query = it)) },
        onCloseClicked = { onEvent(SearchUIEvent.OnCloseClicked) }
    )
}

