package com.aarh.borutoapp.presentation.screens.detail.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.aarh.borutoapp.R
import com.aarh.borutoapp.data.mockdata.HeroProvider.hero2
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.presentation.screens.detail.components.InfoBox
import com.aarh.borutoapp.ui.theme.GraySystemUIColor
import com.aarh.borutoapp.ui.theme.ICON_SIZE
import com.aarh.borutoapp.ui.theme.MEDIUM_PADDING
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
            .fillMaxWidth()
            .padding(all = MIN_LARGE_PADDING)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MIN_LARGE_PADDING),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier
                    .size(ICON_SIZE)
                    .weight(2F),
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo),
                tint = contentColor
            )

            Text(
                modifier = Modifier
                    .weight(8F),
                text = selectedHero.name,
                color = contentColor,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MEDIUM_PADDING)
        ) {
            InfoBox(
                icon = painterResource(id = R.drawable.ic_bolt),
                iconColor = infoBoxIconColor,
                bigText = "${selectedHero.power}",
                smallText = stringResource(R.string.power),
                textColor = contentColor
            )
            InfoBox(
                icon = painterResource(R.drawable.ic_calendar),
                iconColor = infoBoxIconColor,
                bigText = selectedHero.month,
                smallText = stringResource(R.string.month),
                textColor = contentColor,
            )
            InfoBox(
                icon = painterResource(R.drawable.ic_cake),
                iconColor = infoBoxIconColor,
                bigText = selectedHero.day,
                smallText = stringResource(R.string.birthday),
                textColor = contentColor,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BottomSheetContentPreview() {
    BottomSheetContent(selectedHero = hero2)
}