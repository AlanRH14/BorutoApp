package com.aarh.borutoapp.presentation.screens.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aarh.borutoapp.presentation.screens.detail.mvi.DetailUIEvent
import com.aarh.borutoapp.presentation.screens.detail.mvi.UIEvent
import com.aarh.borutoapp.presentation.screens.detail.widgets.DetailsContent
import com.aarh.borutoapp.util.Constants.BASE_URL
import com.aarh.borutoapp.util.PaletteGenerator.convertImageUrlToBitMap
import com.aarh.borutoapp.util.PaletteGenerator.extractColorsFromBitmap
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    heroID: Int,
    detailsViewModel: DetailsViewModel = koinViewModel(),
) {
    val state by detailsViewModel.state.collectAsStateWithLifecycle()
    val mContext = LocalContext.current

    LaunchedEffect(key1 = true) {
        detailsViewModel.onEvent(DetailUIEvent.OnGetSelectedHero(heroID = heroID))
        detailsViewModel.uiEvent.collectLatest { uiEvent ->
            when (uiEvent) {
                is UIEvent.GenerateColorPalette -> {
                    val bitMap = convertImageUrlToBitMap(
                        imageUrl = "$BASE_URL${state.selectedHero?.image}",
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

    if (state.colorPalette.isNotEmpty()) {
        DetailsContent(
            selectedHero = state.selectedHero,
            colors = state.colorPalette,
            onEvent = detailsViewModel::onEvent
        )
    } else {
        detailsViewModel.generateColorPalette()
    }
}