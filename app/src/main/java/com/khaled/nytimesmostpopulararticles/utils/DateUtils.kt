package com.khaled.nytimesmostpopulararticles.utils

import java.util.*

object DateUtils {

    fun isBeforeToday(milliseconds: Long): Boolean {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliseconds
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val todayCalendar = Calendar.getInstance()
        todayCalendar.set(Calendar.HOUR_OF_DAY, 0)
        todayCalendar.set(Calendar.MINUTE, 0)
        todayCalendar.set(Calendar.SECOND, 0)
        todayCalendar.set(Calendar.MILLISECOND, 0)
        return calendar.timeInMillis < todayCalendar.timeInMillis
    }
}