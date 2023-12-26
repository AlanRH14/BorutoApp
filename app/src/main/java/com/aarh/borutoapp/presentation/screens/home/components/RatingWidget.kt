package com.aarh.borutoapp.presentation.screens.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.LightGray
import com.aarh.borutoapp.ui.theme.StarColor
import com.aarh.borutoapp.util.NumberType.*
import com.aarh.borutoapp.util.isNumberType

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double,
    scaleFactor: Float = 3F,
) {
    val startPathString = stringResource(id = R.string.star_path)
    val startPath = remember {
        PathParser().parsePathString(pathData = startPathString).toPath()
    }
    val startPathBounds = remember {
        startPath.getBounds()
    }

    FilledStar(
        startPath = startPath,
        startPathBounds = startPathBounds,
        scaleFactor = scaleFactor,
        rating = rating,
    )
}

@Composable
fun FilledStar(
    startPath: Path,
    startPathBounds: Rect,
    scaleFactor: Float,
    rating: Double,
) {
    Canvas(
        modifier = Modifier
            .size(24.dp),
    ) {
        val canvasSize = this.size
        val colorPath = if (isNumberType(rating) == IS_INT_NUMBER) {
            StarColor
        } else {
            LightGray.copy(alpha = 0.5F)
        }
        scale(scale = scaleFactor) {
            val pathWidth = startPathBounds.width
            val pathHeight = startPathBounds.height
            val left = (canvasSize.width / 2F) - (pathWidth / 1.7F)
            val top = (canvasSize.height / 2F) - (pathHeight / 1.7F)
            val test = 10

            val numberTest = test
            translate(
                left = left,
                top = top,
            ) {
                drawPath(
                    path = startPath,
                    color = colorPath,
                )
                if (isNumberType(rating) == IS_NOT_INT_NUMBER) {
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

@Composable
@Preview(showBackground = true)
fun FilledStarPreview() {
    RatingWidget(modifier = Modifier, rating = 1.0)
}

@Composable
@Preview(showBackground = true)
fun HalfStartPreview() {
    RatingWidget(modifier = Modifier, rating = 0.5)
}
