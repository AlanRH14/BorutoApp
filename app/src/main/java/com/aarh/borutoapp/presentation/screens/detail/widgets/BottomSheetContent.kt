package com.aarh.borutoapp.presentation.screens.detail.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.aarh.borutoapp.R
import com.aarh.borutoapp.data.mockdata.HeroProvider.hero2
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.presentation.screens.detail.components.AboutHero
import com.aarh.borutoapp.presentation.screens.detail.components.FamilyHero
import com.aarh.borutoapp.presentation.screens.detail.components.InfoHero
import com.aarh.borutoapp.presentation.screens.detail.components.HeaderBottomSheet
import com.aarh.borutoapp.presentation.screens.detail.components.OrderedList
import com.aarh.borutoapp.ui.theme.GraySystemUIColor
import com.aarh.borutoapp.ui.theme.MIN_LARGE_PADDING

@Composable
fun BottomSheetContent(
    selectedHero: Hero,
    infoBoxIconColor: Color = MaterialTheme.colorScheme.primary,
    sheetBackgroundColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = GraySystemUIColor,
) {
    Column(
        modifier = Modifier
            .padding(all = MIN_LARGE_PADDING)
            .fillMaxWidth()
    ) {
        HeaderBottomSheet(
            name = selectedHero.name,
            contentColor = contentColor
        )

        InfoHero(
            power = "${selectedHero.power}",
            month = selectedHero.month,
            day = selectedHero.day,
            infoBoxIconColor = infoBoxIconColor,
            contentColor = contentColor
        )

        AboutHero(about = selectedHero.about)

        FamilyHero(
            family = selectedHero.family,
            abilities = selectedHero.abilities,
            natureTypes = selectedHero.natureTypes,
            contentColor = contentColor,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BottomSheetContentPreview() {
    BottomSheetContent(selectedHero = hero2)
}