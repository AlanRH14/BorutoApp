package com.aarh.borutoapp.presentation.screens.error

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.aarh.borutoapp.R
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.ui.theme.GraySystemUIColor
import com.aarh.borutoapp.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import com.aarh.borutoapp.ui.theme.SMALL_PADDING
import com.aarh.borutoapp.util.Constants.FIND_HERO
import com.aarh.borutoapp.util.Constants.INTERNET_UNAVAILABLE
import com.aarh.borutoapp.util.parseErrorMessage

@Composable
fun EmptyScreen(
    error: LoadState.Error? = null,
    heroes: LazyPagingItems<Hero>? = null,
) {
    var message by remember {
        mutableStateOf(FIND_HERO)
    }
    var icon by remember {
        mutableIntStateOf(R.drawable.ic_search_document)
    }

    if (error != null) {
        message = parseErrorMessage(error = error)
        icon = R.drawable.ic_network_error
    }

    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation by animateFloatAsState(
        targetValue = if (startAnimation) 0.38F else 0F,
        animationSpec = tween(durationMillis = 1000),
        label = stringResource(R.string.alpha_animation_label)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

    EmptyContent(
        alphaAnimation = alphaAnimation,
        icon = icon,
        message = message,
        error = error,
        heroes = heroes,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmptyContent(
    alphaAnimation: Float,
    icon: Int,
    message: String,
    error: LoadState.Error? = null,
    heroes: LazyPagingItems<Hero>? = null,
) {
    val swipeRefresh = rememberPullToRefreshState()
    var isRefreshing by remember { mutableStateOf(false) }
    val onRefresh: () -> Unit = {
        isRefreshing = true
        heroes?.refresh()
        isRefreshing = false
    }

    PullToRefreshBox(
        modifier = Modifier
            .pullToRefresh(
                isRefreshing = isRefreshing,
                state = swipeRefresh,
                enabled = error != null,
                onRefresh = onRefresh
            ),
        state = swipeRefresh,
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(NETWORK_ERROR_ICON_HEIGHT)
                    .alpha(alphaAnimation),
                painter = painterResource(icon),
                contentDescription = stringResource(R.string.network_error_icon),
                tint = GraySystemUIColor
            )
            Text(
                modifier = Modifier
                    .padding(top = SMALL_PADDING)
                    .alpha(alphaAnimation),
                text = message,
                color = GraySystemUIColor,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        }
    }
}

@Composable
private fun EmptyScreenMockPreview() {
    EmptyContent(
        alphaAnimation = 0.38F,
        icon = R.drawable.ic_network_error,
        message = INTERNET_UNAVAILABLE
    )
}

@Composable
@Preview(showBackground = true)
private fun EmptyScreenPreview() {
    EmptyScreenMockPreview()
}

@Composable
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFF000000
)
private fun EmptyScreenDarkUIPreview() {
    EmptyScreenMockPreview()
}