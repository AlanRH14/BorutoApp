package com.aarh.borutoapp.util

import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue


@OptIn(ExperimentalMaterial3Api::class)
val BottomSheetScaffoldState.currentSheetFraction: Float
    get() {
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        return when {
            currentValue == SheetValue.Hidden && targetValue == SheetValue.Hidden -> 1F

            currentValue == SheetValue.Expanded && targetValue == SheetValue.Expanded -> 0F

            currentValue == SheetValue.Hidden && targetValue == SheetValue.Expanded -> 1F

            currentValue == SheetValue.Expanded && targetValue == SheetValue.Hidden -> 0F

            else -> 1F
        }
    }