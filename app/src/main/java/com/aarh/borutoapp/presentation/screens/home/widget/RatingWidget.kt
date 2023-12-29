package com.aarh.borutoapp.presentation.screens.home.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.aarh.borutoapp.R
import com.aarh.borutoapp.presentation.screens.home.components.StarIndicator
import com.aarh.borutoapp.presentation.screens.home.components.calculateStars
import com.aarh.borutoapp.ui.theme.SPACY_BETWEEN
import com.aarh.borutoapp.util.Constants.EMPTY_STARS
import com.aarh.borutoapp.util.Constants.FILLED_STARS
import com.aarh.borutoapp.util.Constants.HALF_FILLED_STARTS

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double,
    scaleFactor: Float = 3F,
    spaceBetween: Dp = SPACY_BETWEEN,
) {
    val result = calculateStars(rating = rating)
    val startPathString = stringResource(id = R.string.star_path)
    val startPath = remember {
        PathParser().parsePathString(pathData = startPathString).toPath()
    }
    val startPathBounds = remember {
        startPath.getBounds()
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween),
    ) {
        result[FILLED_STARS]?.let { filledStar ->
            repeat(filledStar) {
                StarIndicator(
                    startPath = startPath,
                    startPathBounds = startPathBounds,
                    scaleFactor = scaleFactor,
                    rating = 1.0,
                )
            }

            result[HALF_FILLED_STARTS]?.let { halfStar ->
                repeat(halfStar) {
                    StarIndicator(
                        startPath = startPath,
                        startPathBounds = startPathBounds,
                        scaleFactor = scaleFactor,
                        rating = 0.5,
                    )
                }
            }

            result[EMPTY_STARS]?.let { emptyStar ->
                repeat(emptyStar) {
                    StarIndicator(
                        startPath = startPath,
                        startPathBounds = startPathBounds,
                        scaleFactor = scaleFactor,
                        rating = 0.0,
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FilledStarPreview() {
    RatingWidget(modifier = Modifier, rating = 5.0)
}

@Composable
@Preview(showBackground = true)
fun HalfFilledStarPreview() {
    RatingWidget(modifier = Modifier, rating = 2.5)
}

@Composable
@Preview(showBackground = true)
fun EmptyStarPreview() {
    RatingWidget(modifier = Modifier, rating = 0.0)
}
