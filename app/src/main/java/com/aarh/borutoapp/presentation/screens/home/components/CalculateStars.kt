package com.aarh.borutoapp.presentation.screens.home.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.aarh.borutoapp.util.Constants

@Composable
fun calculateStars(rating: Double): Map<String, Int> {
    val maxStars by remember { mutableIntStateOf(5) }
    var filledStars by remember { mutableIntStateOf(0) }
    var halfFilledStars by remember { mutableIntStateOf(0) }
    var emptyStars by remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = rating) {
        val (firstNumber, lastNumber) = rating.toString()
            .split(".")
            .map { it.toInt() }

        if (firstNumber in 0..5 && lastNumber in 0..9) {
            filledStars = firstNumber
            if (lastNumber in 1..5) {
                halfFilledStars++
            }
            if (lastNumber in 6..9) {
                filledStars++
            }
            if (firstNumber == 5 && lastNumber > 0) {
                emptyStars = 5
                halfFilledStars = 0
                filledStars = 0
            }
        } else {
            Log.e("RatingWidget", "Invalid Rating number.")
        }
    }

    emptyStars = maxStars - (halfFilledStars + filledStars)

    return hashMapOf(
        Constants.FILLED_STARS to filledStars,
        Constants.HALF_FILLED_STARTS to halfFilledStars,
        Constants.EMPTY_STARS to emptyStars,
    )
}