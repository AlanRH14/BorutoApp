package com.aarh.borutoapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.aarh.borutoapp.presentation.screens.detail.DetailScreen
import com.aarh.borutoapp.presentation.screens.home.HomeScreen
import com.aarh.borutoapp.presentation.screens.search.SearchScreen
import com.aarh.borutoapp.presentation.screens.welcome.WelcomeScreen

@ExperimentalFoundationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Welcome,
    ) {
        composable<Welcome> {
            WelcomeScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable<Home> {
            HomeScreen(navController = navController)
        }

        composable<Details> { heroID ->
            val heroID = heroID.toRoute<Details>().heroID
            DetailScreen(
                heroID = heroID,
                navController = navController
            )
        }

        composable<Search> {
            SearchScreen(navController = navController)
        }
    }
}
