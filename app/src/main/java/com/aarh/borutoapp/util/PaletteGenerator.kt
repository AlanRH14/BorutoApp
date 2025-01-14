package com.aarh.borutoapp.util

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import androidx.palette.graphics.Palette
import coil3.Bitmap
import coil3.ImageLoader
import coil3.request.ImageRequest
import coil3.request.SuccessResult
import coil3.request.allowHardware

object PaletteGenerator {

    suspend fun convertImageUrlTobitMap(
        imageUrl: String,
        context: Context,
    ): Bitmap? {
        val loader = ImageLoader(context = context)
        val request = ImageRequest.Builder(context = context)
            .data(imageUrl)
            .allowHardware(false)
            .build()
        val imageResult = loader.execute(request = request)
        return if (imageResult is SuccessResult) {
            (imageResult.image as BitmapDrawable).bitmap
        } else {
            null
        }
    }

    fun extractColorsFromBitmap(bitmap: Bitmap): Map<String, String> {
        return mapOf(
            PaletteColors.Variant.color to parseColorSwatch(
                color = Palette.from(bitmap).generate().vibrantSwatch
            ),
            PaletteColors.DarkVibrant.color to parseColorSwatch(
                color = Palette.from(bitmap).generate().darkVibrantSwatch
            ),
            PaletteColors.OnDarkVariant.color to parseBodyColor(
                color = Palette.from(bitmap).generate().darkVibrantSwatch?.bodyTextColor
            )
        )
    }

    private fun parseColorSwatch(color: Palette.Swatch?): String {
        return if (color != null) {
            val parsedColor = Integer.toHexString(color.rgb)
            return "#$parsedColor"
        } else {
            "#000000"
        }
    }

    private fun parseBodyColor(color: Int?): String {
        return if (color != null) {
            val parseColor = Integer.toHexString(color)
            "#$parseColor"
        } else {
            "#FFFFFF"
        }
    }
}