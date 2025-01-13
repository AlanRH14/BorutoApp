package com.aarh.borutoapp.presentation.screens.welcome.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.aarh.borutoapp.ui.theme.PurpleUIModeColor
import com.aarh.borutoapp.ui.theme.EXTRA_SMALL_PADDING
import com.aarh.borutoapp.ui.theme.INDICATOR_SIZE
import com.aarh.borutoapp.ui.theme.InactiveIndicatorColor
import com.aarh.borutoapp.ui.theme.SMALL_PADDING
import com.aarh.borutoapp.util.Constants.WELCOME_PAGES_DATA

@ExperimentalFoundationApi
@Composable
fun HorizontalPagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    containerPadding: Dp = SMALL_PADDING,
    indicatorSize: Dp = INDICATOR_SIZE,
    indicatorPadding: Dp = EXTRA_SMALL_PADDING,
    activeColor: Color = PurpleUIModeColor,
    inactiveColor: Color = InactiveIndicatorColor,
) {
    Row(
        modifier = modifier
            .padding(containerPadding)
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) {
                activeColor
            } else {
                inactiveColor
            }
            Box(
                modifier = Modifier
                    .padding(indicatorPadding)
                    .clip(CircleShape)
                    .background(color)
                    .size(indicatorSize),
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
@Preview(showBackground = true)
fun HorizontalPagerIndicatorPreview() {
    val pagerState = rememberPagerState(pageCount = { WELCOME_PAGES_DATA.size })
    HorizontalPagerIndicator(pagerState = pagerState)
}

@ExperimentalFoundationApi
@Composable
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    backgroundColor = 0xFF000000,
    showBackground = true,
)
fun HorizontalPagerIndicatorDArkPreview() {
    val pagerState = rememberPagerState(pageCount = { WELCOME_PAGES_DATA.size })
    HorizontalPagerIndicator(pagerState = pagerState)
}
