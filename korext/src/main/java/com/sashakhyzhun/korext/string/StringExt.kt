package com.sashakhyzhun.korext.string

import android.util.Patterns


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