package com.aarh.borutoapp.presentation.screens.search.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aarh.borutoapp.presentation.screens.search.widgets.SearchWidget

@Composable
fun SearchTopBar(
    modifier: Modifier = Modifier,
    search: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onClose: () -> Unit,
) {
    SearchWidget(
        modifier = modifier,
        text = search,
        onTextChange = onTextChange,
        onSearchClicked = onSearchClicked,
        onCloseClicked = onClose
    )
}

