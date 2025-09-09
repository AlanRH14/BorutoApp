package com.aarh.borutoapp.presentation.screens.detail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.aarh.borutoapp.ui.theme.GraySystemUIColor
import com.aarh.borutoapp.ui.theme.MEDIUM_PADDING

@Composable
fun HeaderBottomSheet(
    name: String,
    contentColor: Color = GraySystemUIColor,
) {
    Row(
        modifier = Modifier
            .padding(bottom = MEDIUM_PADDING)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_logo_short),
            contentDescription = stringResource(R.string.app_logo),
            tint = contentColor,
        )

        Text(
            modifier = Modifier.padding(start = MEDIUM_PADDING),
            text = name,
            color = contentColor,
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderBottomSheetPreview() {
    HeaderBottomSheet(
        name = "Sasuke",
        contentColor = GraySystemUIColor,
    )
}