package com.aarh.borutoapp.presentation.screens.splash.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.BrushLight

@Composable
fun Splash(
    modifier: Modifier = Modifier,
    degrees: Float = 0F,
) {
    if (isSystemInDarkTheme()) {
        Box(
            modifier = modifier
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
            modifier = modifier
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
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun SplashScreenDarkPreview() {
    Splash()
}
