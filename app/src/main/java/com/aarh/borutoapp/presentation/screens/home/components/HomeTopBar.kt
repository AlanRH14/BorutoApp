package com.aarh.borutoapp.presentation.screens.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.TopBarBackgroundColor
import com.aarh.borutoapp.ui.theme.TopBarContentColor

@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.explorer_title),
                color = TopBarContentColor,
            )
        },
        backgroundColor = TopBarBackgroundColor,
        actions = {
            IconButton(onClick = { onSearchClicked.invoke() }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon),
                    tint = TopBarContentColor,
                )
            }
        },
    )
}

@Composable
@Preview
fun HomeTopBarPreview() {
    HomeTopBar {}
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun HomeTopBarDarkPreview() {
    HomeTopBar {}
}
