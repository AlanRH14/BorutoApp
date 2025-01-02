package com.aarh.borutoapp.util.error

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.paging.LoadState

@Composable
fun EmptyScreen(
    error : LoadState.Error
) {
    val message by remember {
        mutableStateOf("")
    }
}

fun parseErrorMessage(message: String): String {
    return when {
        message.contains("SocketTimeoutException") -> {
            "Server Unavailable."
        }

        message.contains("ConnectionException") -> {
            "Internet Unavailable."
        }

        else -> {
            "Unknown Error."
        }
    }
}