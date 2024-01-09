package com.aarh.borutoapp.util

import com.aarh.borutoapp.domain.model.OnBoardingPage

object Constants {
    const val SPLASH_SCREEN_ROUTE = "splash_screen"
    const val WELCOME_SCREEN_ROUTE = "welcome_screen"
    const val HOME_SCREEN_ROUTE = "home_screen"
    const val DETAILS_SCREEN_ROUTE = "details_screen"
    const val SEARCH_SCREEN_ROUTE = "search_screen"

    const val DETAILS_ARGUMENT_KEY = "heroId"
    const val BORUTO_DATABASE = "boruto_database"
    const val HERO_DATABASE_TABLE = "hero_table"
    const val HERO_REMOTE_KEYS_DATABASE_TABLE = "hero_remote_keys_table"

    val WELCOME_PAGES_DATA = listOf(
        OnBoardingPage.FirstPage,
        OnBoardingPage.SecondPage,
        OnBoardingPage.ThirdPage,
    )

    const val PREFERENCES_NAME = "boruto_preferences"
    const val PREFERENCES_KEY = "on_boarding_completed"

    const val BASE_URL = "http://192.168.1.132:8080"

    const val ITEMS_PER_PAGE = 3

    const val EMPTY_STARS = "empty_stars"
    const val HALF_FILLED_STARTS = "half_filled_starts"
    const val FILLED_STARS = "filled_stars"
}
