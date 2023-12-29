package com.aarh.borutoapp.presentation.screens.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp
import com.aarh.borutoapp.ui.theme.EmptyStar
import com.aarh.borutoapp.ui.theme.StarColor
import com.aarh.borutoapp.util.NumberType
import com.aarh.borutoapp.util.isNumberType

@Composable
fun StarIndicator(
    startPath: Path,
    startPathBounds: Rect,
    scaleFactor: Float,
    rating: Double,
) {
    Canvas(
        modifier = Modifier
            .size(24.dp),
    ) {
        val canvasSize = size
        val colorPath = if (rating == 0.0) {
            EmptyStar
        } else {
            if (isNumberType(rating) == NumberType.IS_INT_NUMBER) {
                StarColor
            } else {
                EmptyStar
            }
        }
        scale(scale = scaleFactor) {
            val pathWidth = startPathBounds.width
            val pathHeight = startPathBounds.height
            val left = (canvasSize.width / 2F) - (pathWidth / 1.7F)
            val top = (canvasSize.height / 2F) - (pathHeight / 1.7F)

            translate(
                left = left,
                top = top,
            ) {
                drawPath(
                    path = startPath,
                    color = colorPath,
                )
                if (isNumberType(rating) == NumberType.IS_NOT_INT_NUMBER) {
                    clipPath(path = startPath) {
                        drawRect(
                            color = StarColor,
                            size = Size(
                                width = startPathBounds.maxDimension / 1.7F,
                                height = startPathBounds.maxDimension * scaleFactor,
                            ),
                        )
                    }
                }
            }
        }
    }
}
