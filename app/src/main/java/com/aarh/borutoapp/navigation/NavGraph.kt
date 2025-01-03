package com.aarh.borutoapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aarh.borutoapp.presentation.screens.home.HomeScreen
import com.aarh.borutoapp.presentation.screens.search.SearchScreen
import com.aarh.borutoapp.presentation.screens.splash.SplashScreen
import com.aarh.borutoapp.presentation.screens.welcome.WelcomeScreen
import com.aarh.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun SetupNavGraph(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(
                modifier = modifier,
                navController = navController
            )
        }
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
        ) {}
        composable(route = Screen.Search.route) {
            SearchScreen()
        }
    }
}
