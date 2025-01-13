package com.aarh.borutoapp.presentation.screens.detail.widgets

import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.ui.theme.MIN_SHEET_HEIGHT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsContent(
    navController: NavController,
    selectedHero: Hero?,
) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(initialValue = SheetValue.Expanded)
    )
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = MIN_SHEET_HEIGHT,
        sheetContent = {
            selectedHero?.let { hero -> BottomSheetContent(selectedHero = hero) }
        },
        content = {
            selectedHero?.image?.let { hero ->
                BackgroundContent(
                    heroImage = hero,
                    onCloseClicked = {
                        navController.popBackStack()
                    }
                )
            }
        }
    )
}