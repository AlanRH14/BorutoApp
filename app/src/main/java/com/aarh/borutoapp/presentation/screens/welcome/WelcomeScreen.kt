package com.aarh.borutoapp.presentation.screens.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.aarh.borutoapp.navigation.NavRoutes
import com.aarh.borutoapp.presentation.screens.welcome.components.FinishButton
import com.aarh.borutoapp.presentation.screens.welcome.components.HorizontalPagerIndicator
import com.aarh.borutoapp.presentation.screens.welcome.mvi.WelcomeEffect
import com.aarh.borutoapp.presentation.screens.welcome.mvi.WelcomeUIEvent
import com.aarh.borutoapp.presentation.screens.welcome.widgets.PagerScreen
import com.aarh.borutoapp.ui.theme.WelcomeScreenBackground
import com.aarh.borutoapp.util.Constants.WELCOME_PAGES_DATA
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@ExperimentalFoundationApi
@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = koinViewModel(),
) {

    LaunchedEffect(key1 = true) {
        welcomeViewModel.onEvent(WelcomeUIEvent.OnGetOnBoardingState)
        welcomeViewModel.effect.collectLatest {
            when (it) {
                is WelcomeEffect.NavigateToHome -> {
                    navController.popBackStack()
                    navController.navigate(NavRoutes.Home.route)
                }
            }
        }
    }

    Column(
        modifier = modifier
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

        FinishButton(
            modifier = Modifier
                .weight(1F),
            pagerState = pagerState,
            onEvent = welcomeViewModel::onEvent
        )
    }
}
