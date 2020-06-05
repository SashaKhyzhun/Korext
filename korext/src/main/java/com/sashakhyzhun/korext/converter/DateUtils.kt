package com.sashakhyzhun.korext.converter

import java.text.SimpleDateFormat
import java.util.*


/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */


fun now() = System.currentTimeMillis()


fun today(format: String) = SimpleDateFormat(format, Locale.getDefault()).format(Date())


fun convertJsonData(dateFromJSON: String, inputPattern: String, outputPattern: String): String? {
    return if (dateFromJSON.isNotEmpty()) {
        val originalMonthYear = SimpleDateFormat(inputPattern, Locale.getDefault())
        val date = originalMonthYear.parse(dateFromJSON)
        val formatter = SimpleDateFormat(outputPattern, Locale.getDefault())
        formatter.format(date)
    } else {
        null
    }
}

