package com.aarh.borutoapp.util

import com.aarh.borutoapp.util.Constants.CONNECTION_EXCEPTION
import com.aarh.borutoapp.util.Constants.INTERNET_UNAVAILABLE
import com.aarh.borutoapp.util.Constants.SERVER_UNAVAILABLE
import com.aarh.borutoapp.util.Constants.SOCKET_TIME_OUT_EXCEPTION
import com.aarh.borutoapp.util.Constants.UNKNOWN_ERROR

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