package com.aarh.borutoapp.presentation.screens.home.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.aarh.borutoapp.R
import com.aarh.borutoapp.presentation.screens.home.components.StarIndicator

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

    StarIndicator(
        startPath = startPath,
        startPathBounds = startPathBounds,
        scaleFactor = scaleFactor,
        rating = rating,
    )
}

@Composable
@Preview(showBackground = true)
fun FilledStarPreview() {
    RatingWidget(modifier = Modifier, rating = 1.0)
}

@Composable
@Preview(showBackground = true)
fun HalfFilledStarPreview() {
    RatingWidget(modifier = Modifier, rating = 0.5)
}

@Composable
@Preview(showBackground = true)
fun EmptyStarPreview() {
    RatingWidget(modifier = Modifier, rating = 0.0)
}
