package com.aarh.borutoapp.presentation.screens.detail.components


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
import com.aarh.borutoapp.R
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.ui.theme.GraySystemUIColor
import com.aarh.borutoapp.ui.theme.ICON_SIZE
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
                text = selectedHero.name,
                color = contentColor,
                fontWeight = FontWeight.Bold
            )
        }
    }
}