package com.aarh.borutoapp.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.BrushLight

@Composable
fun SplashScreen(
    navController: NavHostController,
) {
    val degrees = remember { Animatable(0F) }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 369F,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200,
            ),
        )
    }
    Splash(degrees = degrees.value)
}

@Composable
fun Splash(degrees: Float = 0F) {
    if (isSystemInDarkTheme()) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo),
                modifier = Modifier.rotate(degrees = degrees),
            )
        }
    } else {
        Box(
            modifier = Modifier
                .background(Brush.verticalGradient(BrushLight))
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(id = R.string.app_logo),
                modifier = Modifier.rotate(degrees = degrees),
            )
        }
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash()
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashScreenDarkPreview() {
    Splash()
}
