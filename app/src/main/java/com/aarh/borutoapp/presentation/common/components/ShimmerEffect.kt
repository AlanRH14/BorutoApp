package com.aarh.borutoapp.presentation.common.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.aarh.borutoapp.ui.theme.ABOUT_PLACEHOLDER_HEIGHT
import com.aarh.borutoapp.ui.theme.HERO_ITEM_HEIGHT
import com.aarh.borutoapp.ui.theme.LARGE_PADDING
import com.aarh.borutoapp.ui.theme.MEDIUM_PADDING
import com.aarh.borutoapp.ui.theme.NAME_PLACEHOLDER_HEIGHT
import com.aarh.borutoapp.ui.theme.RATING_PLACEHOLDER_HEIGHT
import com.aarh.borutoapp.ui.theme.SMALL_PADDING
import com.aarh.borutoapp.ui.theme.ShimmerBackgroundColor
import com.aarh.borutoapp.ui.theme.ShimmerItemGradientBackgroundColor
import com.aarh.borutoapp.util.animatedShimmerItem

@Composable
fun ShimmerEffect() {
}

@Composable
fun ShimmerItem() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(HERO_ITEM_HEIGHT),
        color = ShimmerBackgroundColor,
        shape = RoundedCornerShape(size = LARGE_PADDING),
    ) {
        Column(
            modifier = Modifier
                .padding(all = MEDIUM_PADDING),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5F)
                    .height(NAME_PLACEHOLDER_HEIGHT)
                    .clip(RoundedCornerShape(size = SMALL_PADDING))
                    .animatedShimmerItem(1000, ShimmerItemGradientBackgroundColor),
            ) {}

            Spacer(modifier = Modifier.padding(all = SMALL_PADDING))

            repeat(3) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ABOUT_PLACEHOLDER_HEIGHT)
                        .clip(RoundedCornerShape(size = SMALL_PADDING))
                        .animatedShimmerItem(1000, ShimmerItemGradientBackgroundColor),
                ) {}
                Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                repeat(5) {
                    Box(
                        modifier = Modifier
                            .size(RATING_PLACEHOLDER_HEIGHT)
                            .clip(RoundedCornerShape(size = SMALL_PADDING))
                            .animatedShimmerItem(1000, ShimmerItemGradientBackgroundColor),
                    ) {}
                    Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
                }
            }
        }
    }
}

@Composable
@Preview
fun ShimmerItemPreview() {
    ShimmerItem()
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun ShimmerItemDarkPreview() {
    ShimmerItem()
}
