package com.aarh.borutoapp.presentation.screens.detail

import androidx.compose.ui.graphics.Color
import com.aarh.borutoapp.domain.entity.Hero

data class DetailsState(
    val isLoading: Boolean = false,
    val selectedHero: Hero? = null,
    val colorPalette: Map<String, Color> = emptyMap()
)
