package com.sashakhyzhun.androidcommonutils.context


import android.content.Context
import android.view.inputmethod.InputMethodManager


/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */

/**
 * Returns InputMethodManager
 *
 * @return instance of InputMethodManager
 *
 * @see Context.getSystemService
 * @see Context.INPUT_METHOD_SERVICE
 * @see InputMethodManager
 */
fun Context.inputMethodService() =
    getService<InputMethodManager>(Context.INPUT_METHOD_SERVICE)

/**
 * Returns class representing service with provided name
 *
 * @param[name] - name of the needed service
 *
 * @return instance of HardwarePropertiesManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 */
private inline fun <reified T> Context.getService(name: String): T = getSystemService(name) as T