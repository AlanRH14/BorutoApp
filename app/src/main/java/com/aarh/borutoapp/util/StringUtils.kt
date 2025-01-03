package com.aarh.borutoapp.util

import androidx.paging.LoadState
import com.aarh.borutoapp.util.Constants.INTERNET_UNAVAILABLE
import com.aarh.borutoapp.util.Constants.SERVER_UNAVAILABLE
import com.aarh.borutoapp.util.Constants.UNKNOWN_ERROR
import io.ktor.client.network.sockets.SocketTimeoutException
import java.net.ConnectException

fun parseErrorMessage(error: LoadState.Error): String {
    return when (error.error) {
        is SocketTimeoutException -> {
            SERVER_UNAVAILABLE
        }

        is ConnectException -> {
            INTERNET_UNAVAILABLE
        }

        else -> {
            UNKNOWN_ERROR
        }
    }
}