package com.aarh.borutoapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aarh.borutoapp.presentation.screens.detail.DetailScreen
import com.aarh.borutoapp.presentation.screens.home.HomeScreen
import com.aarh.borutoapp.presentation.screens.search.SearchScreen
import com.aarh.borutoapp.presentation.screens.welcome.WelcomeScreen
import com.aarh.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY

@ExperimentalFoundationApi
@Composable
fun SetupNavGraph(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route,
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(
                modifier = modifier,
                navController = navController
            )
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(DETAILS_ARGUMENT_KEY) {
                    type = NavType.IntType
                },
            ),
        ) {
            DetailScreen(navController = navController)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }
    }
}
