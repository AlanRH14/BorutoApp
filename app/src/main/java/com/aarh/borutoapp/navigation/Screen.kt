package com.aarh.borutoapp.navigation

import com.aarh.borutoapp.util.Constants.DETAILS_SCREEN_ROUTE
import com.aarh.borutoapp.util.Constants.HOME_SCREEN_ROUTE
import com.aarh.borutoapp.util.Constants.SEARCH_SCREEN_ROUTE
import com.aarh.borutoapp.util.Constants.SPLASH_SCREEN_ROUTE
import com.aarh.borutoapp.util.Constants.WELCOME_SCREEN_ROUTE

sealed class Screen(val route: String) {
    data object Splash : Screen(route = SPLASH_SCREEN_ROUTE)
    data object Welcome : Screen(route = WELCOME_SCREEN_ROUTE)
    data object Home : Screen(route = HOME_SCREEN_ROUTE)
    data object Details : Screen(route = "$DETAILS_SCREEN_ROUTE/{heroId}") {
        fun passHeroId(heroId: Int) = "$DETAILS_SCREEN_ROUTE/$heroId"
    }

    data object Search : Screen(route = SEARCH_SCREEN_ROUTE)
}
