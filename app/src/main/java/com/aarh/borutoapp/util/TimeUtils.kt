package com.aarh.borutoapp.util

fun getInitialRefreshData(
    lastUpdated: Long,
    cacheTimeout: Int = 1440,
): Boolean {
    val currentTime = System.currentTimeMillis()
    val diffInMinutes = (currentTime - lastUpdated) / 1000 / 60

    return (diffInMinutes.toInt() <= cacheTimeout)
}

/*fun parseMillis(
    millis: Long,
): String {
    val date = Date(millis)
    val format = SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.ROOT)

    return format.format(date)
}*/
