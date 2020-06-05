package com.sashakhyzhun.korext.utils

import android.os.Build
import android.util.Patterns
import java.text.SimpleDateFormat
import java.util.*


fun empty() = ""


/**
 * Check if this string is valid web url
 *
 * @see Patterns.WEB_URL
 */
fun String.isValidWebUrl() = Patterns.WEB_URL.matcher(this).matches()

/**
 * Check if this string is valid web url
 *
 * @see Patterns.EMAIL_ADDRESS
 */
fun String.isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()

/**
 * Check if this string is valid web url
 *
 * @see Patterns.PHONE
 */
fun String.isValidPhoneNumber() = Patterns.PHONE.matcher(this).matches()

/**
 * Pattern to check if text contains only letters
 */
fun String.isLettersOnly(): Boolean {
	val chars = this.toCharArray()
	for (c in chars) {
		if (!Character.isLetter(c)) {
			return false
		}
	}
	return true
}



/**
 * example: "2018-09-10 22:01:00".toDate().formatTo("dd MMM yyyy")
 * output: "11 Sep 2018"
 */
fun String.toDate(
	inputDateFormat: String = "yyyy-MM-dd HH:mm:ss",
	inputTimeZone: TimeZone = TimeZone.getTimeZone("UTC"),
	outputDateFormat: String,
	outputTimeZone: TimeZone = TimeZone.getDefault()
): String {
	val parser = SimpleDateFormat(inputDateFormat, Locale.getDefault())
	parser.timeZone = inputTimeZone
	return parser.parse(this).formatTo(outputDateFormat, outputTimeZone)
}