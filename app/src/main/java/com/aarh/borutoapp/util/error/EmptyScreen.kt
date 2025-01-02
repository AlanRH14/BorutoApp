package com.aarh.borutoapp.util.error

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.paging.LoadState
import com.aarh.borutoapp.util.Constants.CONNECTION_EXCEPTION
import com.aarh.borutoapp.util.Constants.INTERNET_UNAVAILABLE
import com.aarh.borutoapp.util.Constants.SERVER_UNAVAILABLE
import com.aarh.borutoapp.util.Constants.SOCKET_TIME_OUT_EXCEPTION
import com.aarh.borutoapp.util.Constants.UNKNOWN_ERROR

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
        message.contains(SOCKET_TIME_OUT_EXCEPTION) -> {
            SERVER_UNAVAILABLE
        }

        message.contains(CONNECTION_EXCEPTION) -> {
            INTERNET_UNAVAILABLE
        }

        else -> {
            UNKNOWN_ERROR
        }
    }
}