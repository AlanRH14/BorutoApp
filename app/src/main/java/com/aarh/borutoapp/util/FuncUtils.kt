package com.aarh.borutoapp.util

import com.aarh.borutoapp.util.NumberType.*

private fun isIntNumber(number: Double): Boolean =
    number % 1 == 0.0

fun isNumberType(number: Double): NumberType =
    if (isIntNumber(number)) {
        IS_INT_NUMBER
    } else {
        IS_NOT_INT_NUMBER
    }
