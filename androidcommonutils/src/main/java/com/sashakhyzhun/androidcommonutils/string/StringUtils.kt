package com.sashakhyzhun.androidcommonutils.string

import android.util.Patterns

/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */

fun empty() = ""


fun fixPlurals(n: Int, s: String): String = when (n) {
    0, 1 -> "$n $s"
    else -> "$n $s" + "s"
}

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