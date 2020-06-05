package com.sashakhyzhun.korext.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Alexander Khyzhun on 05 June 2020.
 */

fun midnightNext(): Long = Date(Date().time + 24 * 60 * 60 * 1000).time

fun now() = System.currentTimeMillis()

fun Long.isToday(): Boolean = (this in midnight()..midnightNext())

fun midnight(): Long {
	val time: Long = Date().time
	return Date(time - time % (24 * 60 * 60 * 1000)).time
}

fun Date.formatTo(dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): String {
	val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
	formatter.timeZone = timeZone
	return formatter.format(this)
}
