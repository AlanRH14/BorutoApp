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
    const val BORUTO_DATABASE_TEST = "test_database.db"
    const val HERO_DATABASE_TABLE = "hero_table"
    const val HERO_REMOTE_KEYS_DATABASE_TABLE = "hero_remote_keys_table"

    val WELCOME_PAGES_DATA = listOf(
        OnBoardingPage.FirstPage,
        OnBoardingPage.SecondPage,
        OnBoardingPage.ThirdPage,
    )

    const val PREFERENCES_NAME = "boruto_preferences"
    const val PREFERENCES_KEY = "on_boarding_completed"

    //const val BASE_URL = "http://10.0.2.2:8080"
    const val BASE_URL = "https://boruto-server-yxw3.onrender.com"

    const val ITEMS_PER_PAGE = 3

    const val EMPTY_STARS = "empty_stars"
    const val HALF_FILLED_STARTS = "half_filled_starts"
    const val FILLED_STARS = "filled_stars"

    const val SERVER_UNAVAILABLE = "Server Unavailable."
    const val INTERNET_UNAVAILABLE = "Internet Unavailable."
    const val UNKNOWN_ERROR = "Unknown Error."
    const val FIND_HERO = "Find your Favorite Hero!"

    const val MAX_LINES_TEXT = 7
    const val MIN_BACKGROUND_IMAGE_HEIGHT = 0.4F

    const val VIBRANT_COLOR = "vibrant"
    const val DARK_VIBRANT_COLOR = "darkVibrant"
    const val ON_DARK_VIBRANT_COLOR = "onDarkVariant"
}
