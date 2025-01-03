package com.aarh.borutoapp.presentation.screens.search.components

import androidx.compose.runtime.Composable
import com.aarh.borutoapp.presentation.screens.search.widgets.SearchWidget

@Composable
fun SearchTopBar(
    search: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onClose: () -> Unit,
) {
    SearchWidget(
        text = search,
        onTextChange = onTextChange,
        onSearchClicked = onSearchClicked,
        onCloseClicked = onClose
    )
}