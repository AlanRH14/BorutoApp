package com.aarh.borutoapp.presentation.screens.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aarh.borutoapp.ui.theme.WelcomeScreenBackground
import com.aarh.borutoapp.util.Constants.WELCOME_PAGES_DATA

@ExperimentalFoundationApi
@Composable
fun WelcomeScreen(
    navController: NavHostController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WelcomeScreenBackground),
    ) {
        val pagerState = rememberPagerState(pageCount = { WELCOME_PAGES_DATA.size })

        HorizontalPager(
            modifier = Modifier
                .weight(10F),
            state = pagerState,
        ) { position ->

            PagerScreen(onBoardingPage = WELCOME_PAGES_DATA[position])
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1F),
            pagerState = pagerState,
        )

        FinisButton(
            modifier = Modifier
                .weight(1F),
            pagerState = pagerState,
        ) {}
    }
}

@ExperimentalFoundationApi
@Composable
@Preview
fun WelcomeScreenPreview() {
    val navController = rememberNavController()
    WelcomeScreen(navController = navController)
}
