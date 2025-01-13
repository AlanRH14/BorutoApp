package com.aarh.borutoapp.presentation.screens.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.GraySystemUIColor

@Composable
fun FamilyHero(
    family: List<String>,
    abilities: List<String>,
    natureTypes: List<String>,
    contentColor: Color = GraySystemUIColor,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OrderedList(
            title = stringResource(R.string.family),
            items = family,
            textColor = contentColor,
        )
        OrderedList(
            title = stringResource(R.string.abilities),
            items = abilities,
            textColor = contentColor,
        )
        OrderedList(
            title = stringResource(R.string.nature_types),
            items = natureTypes,
            textColor = contentColor,
        )
    }
}