package com.aarh.borutoapp.presentation.screens.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.aarh.borutoapp.R
import com.aarh.borutoapp.presentation.screens.home.HomeUIEvent
import com.aarh.borutoapp.ui.theme.TopBarBackgroundColor
import com.aarh.borutoapp.ui.theme.TopBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    onEvent: (HomeUIEvent) -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.explorer_title),
                color = TopBarContentColor,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = TopBarBackgroundColor
        ),
        actions = {
            IconButton(onClick = { onEvent(HomeUIEvent.OnClickHeroItem) }) {
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
