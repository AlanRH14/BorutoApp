package com.aarh.borutoapp.presentation.screens.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.aarh.borutoapp.presentation.screens.home.components.HomeTopBar

@ExperimentalMaterial3Api
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeTopBar {}
        },

    ) { paddingValues -> }
}
