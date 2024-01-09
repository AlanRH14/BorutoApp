package com.aarh.borutoapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)

val BrushLight = listOf(Purple700, Purple500)
val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)
val StarColor = Color(0xFFFFC94D)
val EmptyStar = LightGray.copy(alpha = 0.5F)

val ShimmerLightGray = Color(0xFFF1F1F1)
val ShimmerMediumGray = Color(0xFFE3E3E3)
val ShimmerDarkGray = Color(0xFF1D1D1D)

val LinearLightGradientColors = listOf(
    LightGray,
    ShimmerMediumGray,
    LightGray,
)
val LinearDarkGradientColors = listOf(
    DarkGray,
    ShimmerDarkGray,
    DarkGray,
)
val WelcomeScreenBackground
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Color.White
val TitleColor
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else DarkGray
val DescriptionColor
    @Composable
    get() = if (isSystemInDarkTheme()) {
        LightGray.copy(alpha = 0.5F)
    } else {
        DarkGray.copy(alpha = 0.5F)
    }
val PurpleUIModeColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple700 else Purple500
val InactiveIndicatorColor
    @Composable
    get() = if (isSystemInDarkTheme()) DarkGray else LightGray
val TopBarContentColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else Color.White
val TopBarBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Purple500
val ShimmerBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else ShimmerLightGray
val ShimmerItemGradientBackgroundColor: List<Color>
    @Composable
    get() = if (isSystemInDarkTheme()) LinearDarkGradientColors else LinearLightGradientColors
