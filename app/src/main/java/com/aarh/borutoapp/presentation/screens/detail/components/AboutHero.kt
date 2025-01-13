package com.aarh.borutoapp.presentation.screens.detail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.GraySystemUIColor
import com.aarh.borutoapp.ui.theme.MEDIUM_PADDING
import com.aarh.borutoapp.util.Constants.MAX_LINES_TEXT

@Composable
fun AboutHero(
    about: String,
    contentColor: Color = GraySystemUIColor
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.about),
        color = contentColor,
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        fontWeight = FontWeight.Bold
    )
    Text(
        modifier = Modifier
            .padding(bottom = MEDIUM_PADDING)
            .alpha(alpha = 0.74F),
        text = about,
        color = contentColor,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        maxLines = MAX_LINES_TEXT
    )
}