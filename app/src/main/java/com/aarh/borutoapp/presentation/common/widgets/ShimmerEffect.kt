package com.aarh.borutoapp.presentation.common.widgets

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aarh.borutoapp.presentation.common.components.ShimmerItem
import com.aarh.borutoapp.ui.theme.SMALL_PADDING

@Composable
fun ShimmerEffect() {
    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING),
    ) {
        items(count = 2) {
            ShimmerItem()
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
)
fun ShimmerEffectPreview() {
    ShimmerEffect()
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_YES,
)
fun ShimmerEffectDarkPreview() {
    ShimmerEffect()
}
