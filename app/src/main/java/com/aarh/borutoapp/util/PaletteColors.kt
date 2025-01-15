package com.aarh.borutoapp.util

import com.aarh.borutoapp.util.Constants.DARK_VIBRANT_COLOR
import com.aarh.borutoapp.util.Constants.ON_DARK_VIBRANT_COLOR
import com.aarh.borutoapp.util.Constants.VIBRANT_COLOR

sealed class PaletteColors(val color: String) {
    data object Variant : PaletteColors(color = VIBRANT_COLOR)
    data object DarkVibrant : PaletteColors(color = DARK_VIBRANT_COLOR)
    data object OnDarkVariant : PaletteColors(color = ON_DARK_VIBRANT_COLOR)
}