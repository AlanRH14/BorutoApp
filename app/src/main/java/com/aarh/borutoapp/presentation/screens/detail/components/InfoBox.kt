package com.aarh.borutoapp.presentation.screens.detail.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.GraySystemUIColor
import com.aarh.borutoapp.ui.theme.ICON_SIZE
import com.aarh.borutoapp.ui.theme.SMALL_PADDING

@Composable
fun InfoBox(
    icon: Painter,
    iconColor: Color,
    bigText: String,
    smallText: String,
    textColor: Color,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(ICON_SIZE)
                .padding(end = SMALL_PADDING),
            painter = icon,
            contentDescription = stringResource(R.string.info_icon_description),
            tint = iconColor
        )
        Column {
            Text(
                text = bigText,
                color = textColor,
                textAlign = TextAlign.Center,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = FontWeight.Black,
            )
            Text(
                modifier = Modifier
                    .alpha(alpha = 0.74F),
                text = smallText,
                color = textColor,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun InfoBoxPreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_bolt),
        iconColor = MaterialTheme.colorScheme.primary,
        bigText = "92",
        smallText = "Power",
        textColor = GraySystemUIColor
    )
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun InfoBoxDarkThemePreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_bolt),
        iconColor = MaterialTheme.colorScheme.primary,
        bigText = "92",
        smallText = "Power",
        textColor = GraySystemUIColor
    )
}