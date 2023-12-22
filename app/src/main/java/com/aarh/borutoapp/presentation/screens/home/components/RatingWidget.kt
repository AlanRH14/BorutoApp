package com.aarh.borutoapp.presentation.screens.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.StarColor

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double,
) {
    val startPathString = stringResource(id = R.string.star_path)
    val startPath = remember {
        PathParser().parsePathString(pathData = startPathString).toPath()
    }
    val startPathBounds = remember {
        startPath.getBounds()
    }

    FilledStar(startPath = startPath, startPathBounds = startPathBounds)
}

@Composable
fun FilledStar(
    startPath: Path,
    startPathBounds: Rect,
    scaleFactor: Float = 2F,
) {
    Canvas(
        modifier = Modifier
            .size(24.dp),
    ) {
        val canvasSize = this.size
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
                    color = StarColor,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FilledStarPreview() {
    RatingWidget(modifier = Modifier, rating = 1.0)
}
