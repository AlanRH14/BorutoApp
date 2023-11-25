package com.aarh.borutoapp.util

import com.aarh.borutoapp.domain.model.OnBoardingPage

object Constants {
    const val DETAILS_ARGUMENT_KEY = "heroId"
    const val BORUTO_DATABASE = "boruto_database"
    const val HERO_DATABASE_TABLE = "hero_table"
    const val HERO_REMOTE_KEY_TABLE = "hero_remote_key_table"
    val WELCOME_PAGES_DATA = listOf(
        OnBoardingPage.FirstPage,
        OnBoardingPage.SecondPage,
        OnBoardingPage.ThirdPage,
    )
}
