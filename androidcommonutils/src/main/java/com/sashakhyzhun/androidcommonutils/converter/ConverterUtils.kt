package com.sashakhyzhun.androidcommonutils.converter

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */


@SuppressLint("SimpleDateFormat")
fun convertJsonData(dateFromJSON: String, inputPattern: String, outputPattern: String): String? {
    return if (dateFromJSON.isNotEmpty()) {
        val originalMonthYear = SimpleDateFormat(inputPattern)
        val date = originalMonthYear.parse(dateFromJSON)
        val formatter = SimpleDateFormat(outputPattern)
        formatter.format(date)
    } else {
        null
    }
}