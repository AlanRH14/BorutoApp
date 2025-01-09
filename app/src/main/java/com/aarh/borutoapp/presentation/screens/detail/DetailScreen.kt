package com.aarh.borutoapp.presentation.screens.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.aarh.borutoapp.presentation.screens.detail.widgets.DetailsContent

@Composable
fun DetailScreen(
    navController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel(),
) {
    val selectedHero by detailsViewModel.selectedHero.collectAsState()

    DetailsContent(navController = navController, selectedHero = selectedHero)
}