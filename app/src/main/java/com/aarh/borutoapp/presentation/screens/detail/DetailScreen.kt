package com.aarh.borutoapp.presentation.screens.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.aarh.borutoapp.presentation.screens.detail.widgets.DetailsContent
import com.aarh.borutoapp.util.Constants.BASE_URL
import com.aarh.borutoapp.util.PaletteGenerator.convertImageUrlToBitMap
import com.aarh.borutoapp.util.PaletteGenerator.extractColorsFromBitmap
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    navController: NavHostController,
    detailsViewModel: DetailsViewModel = koinViewModel(),
) {
    val selectedHero by detailsViewModel.selectedHero.collectAsStateWithLifecycle()
    val colorPalette by detailsViewModel.colorPalette.collectAsStateWithLifecycle()
    val mContext = LocalContext.current

    if (colorPalette.isNotEmpty()) {
        DetailsContent(
            navController = navController,
            selectedHero = selectedHero,
            colors = colorPalette
        )
    } else {
        detailsViewModel.generateColorPalette()
    }

    LaunchedEffect(key1 = true) {
        detailsViewModel.uiEvent.collectLatest { uiEvent ->
            when (uiEvent) {
                is UIEvent.GenerateColorPalette -> {
                    val bitMap = convertImageUrlToBitMap(
                        imageUrl = "$BASE_URL${selectedHero?.image}",
                        mContext = mContext
                    )

                    if (bitMap != null) {
                        detailsViewModel.setColorPalette(
                            colors = extractColorsFromBitmap(
                                bitmap = bitMap
                            )
                        )
                    }
                }

                null -> Unit
            }
        }
    }
}