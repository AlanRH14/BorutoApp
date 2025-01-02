package com.aarh.borutoapp.util.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.GraySystemUIColor
import com.aarh.borutoapp.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import com.aarh.borutoapp.ui.theme.SMALL_PADDING
import com.aarh.borutoapp.util.parseErrorMessage
import io.ktor.client.network.sockets.SocketTimeoutException

@Composable
fun EmptyScreen(
    error: LoadState.Error
) {
    val message by remember {
        mutableStateOf(parseErrorMessage(error.toString()))
    }
    val icon by remember {
        mutableIntStateOf(R.drawable.ic_network_error)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.size(NETWORK_ERROR_ICON_HEIGHT),
            painter = painterResource(icon),
            contentDescription = stringResource(R.string.network_error_icon),
            tint = GraySystemUIColor
        )
        Text(
            modifier = Modifier
                .padding(top = SMALL_PADDING),
            text = message,
            color = GraySystemUIColor,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.titleLarge.fontSize
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun EmptyScreenPreview() {
    EmptyScreen(error = LoadState.Error(SocketTimeoutException()))
}