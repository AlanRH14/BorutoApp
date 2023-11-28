package com.aarh.borutoapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.aarh.borutoapp.presentation.screens.home.components.HomeTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeTopBar {}
        },
    ) { paddingValues -> }
}
