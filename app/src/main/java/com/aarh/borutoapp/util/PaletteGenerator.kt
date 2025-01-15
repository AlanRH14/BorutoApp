package com.aarh.borutoapp.util

import android.content.Context
import androidx.palette.graphics.Palette
import coil3.Bitmap
import coil3.BitmapImage
import coil3.ImageLoader
import coil3.request.ImageRequest
import coil3.request.SuccessResult
import coil3.request.allowHardware

object PaletteGenerator {

    suspend fun convertImageUrlToBitMap(
        imageUrl: String,
        mContext: Context,
    ): Bitmap? {
        val loader = ImageLoader(context = mContext)
        val request = ImageRequest.Builder(context = mContext)
            .data(imageUrl)
            .allowHardware(false)
            .build()
        val imageResult = loader.execute(request = request)
        return if (imageResult is SuccessResult) {
            (imageResult.image as BitmapImage).bitmap
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