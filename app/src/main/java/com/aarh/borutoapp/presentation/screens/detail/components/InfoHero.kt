package com.aarh.borutoapp.presentation.screens.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.GraySystemUIColor
import com.aarh.borutoapp.ui.theme.MEDIUM_PADDING

@Composable
fun InfoHero(
    power: String,
    month: String,
    day: String,
    infoBoxIconColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = GraySystemUIColor,
) {
    Row(
        modifier = Modifier
            .padding(bottom = MEDIUM_PADDING)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        InfoBox(
            icon = painterResource(id = R.drawable.ic_bolt),
            iconColor = infoBoxIconColor,
            bigText = power,
            smallText = stringResource(R.string.power),
            textColor = contentColor
        )
        InfoBox(
            icon = painterResource(R.drawable.ic_calendar),
            iconColor = infoBoxIconColor,
            bigText = month,
            smallText = stringResource(R.string.month),
            textColor = contentColor,
        )
        InfoBox(
            icon = painterResource(R.drawable.ic_cake),
            iconColor = infoBoxIconColor,
            bigText = day,
            smallText = stringResource(R.string.birthday),
            textColor = contentColor,
        )
    }
}