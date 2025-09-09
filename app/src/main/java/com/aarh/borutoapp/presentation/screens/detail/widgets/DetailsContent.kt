package com.aarh.borutoapp.presentation.screens.detail.widgets

import android.graphics.Color.parseColor
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.presentation.screens.detail.mvi.DetailUIEvent
import com.aarh.borutoapp.ui.theme.EXPANDED_RADIUS_LEVEL
import com.aarh.borutoapp.ui.theme.EXTRA_LARGE_PADDING
import com.aarh.borutoapp.ui.theme.MIN_SHEET_HEIGHT
import com.aarh.borutoapp.util.Constants.DARK_VIBRANT_COLOR
import com.aarh.borutoapp.util.Constants.MIN_BACKGROUND_IMAGE_HEIGHT
import com.aarh.borutoapp.util.Constants.ON_DARK_VIBRANT_COLOR
import com.aarh.borutoapp.util.Constants.VIBRANT_COLOR
import com.aarh.borutoapp.util.currentSheetFraction
import androidx.core.graphics.toColorInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsContent(
    onEvent: (DetailUIEvent) -> Unit,
    selectedHero: Hero?,
    colors: Map<String, String>,
) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(initialValue = SheetValue.Expanded)
    )
    val currentSheetFraction = scaffoldState.currentSheetFraction
    val radiusAnim by animateDpAsState(
        targetValue = if (currentSheetFraction == 1F) {
            EXTRA_LARGE_PADDING
        } else {
            EXPANDED_RADIUS_LEVEL
        },
        label = ""
    )
    var vibrant by remember { mutableStateOf("#000000") }
    var darkVibrant by remember { mutableStateOf("#000000") }
    var onDarkVibrant by remember { mutableStateOf("#FFFFFF") }

    LaunchedEffect(key1 = selectedHero) {
        vibrant = colors[VIBRANT_COLOR] ?: "#000000"
        darkVibrant = colors[DARK_VIBRANT_COLOR] ?: "#000000"
        onDarkVibrant = colors[ON_DARK_VIBRANT_COLOR] ?: "#FFFFFF"
    }

    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(
            topStart = radiusAnim,
            topEnd = radiusAnim
        ),
        scaffoldState = scaffoldState,
        sheetPeekHeight = MIN_SHEET_HEIGHT,
        sheetContainerColor = Color(darkVibrant.toColorInt()),
        sheetDragHandle = {},
        sheetContent = {
            selectedHero?.let { hero ->
                BottomSheetContent(
                    selectedHero = hero,
                    infoBoxIconColor = Color(vibrant.toColorInt()),
                    sheetBackgroundColor = Color(parseColor(darkVibrant)),
                    contentColor = Color(parseColor(onDarkVibrant))
                )
            }
        },
        content = {
            selectedHero?.image?.let { hero ->
                BackgroundContent(
                    heroImage = hero,
                    imageFraction = currentSheetFraction + MIN_BACKGROUND_IMAGE_HEIGHT,
                    backgroundColor = Color(parseColor(darkVibrant)),
                    onCloseClicked = { onEvent(DetailUIEvent.OnBackClicked) }
                )
            }
        }
    )
}