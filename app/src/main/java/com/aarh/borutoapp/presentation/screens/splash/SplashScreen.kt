package com.aarh.borutoapp.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.aarh.borutoapp.navigation.Screen
import com.aarh.borutoapp.presentation.screens.splash.components.Splash
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    splashViewModel: SplashViewModel = koinViewModel(),
) {
    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()
    val degrees = remember { Animatable(0F) }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 360F,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200,
            ),
        )

        navController.popBackStack()
        if (onBoardingCompleted) {
            navController.navigate(Screen.Home.route)
        } else {
            navController.navigate(Screen.Welcome.route)
        }
    }

    Splash(
        modifier = modifier,
        degrees = degrees.value
    )
}
