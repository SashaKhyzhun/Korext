package com.sashakhyzhun.androidcommonutils.android

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.net.ConnectivityManager
import android.view.WindowManager


/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
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


fun Context.connectivityManager() =
        getService<ConnectivityManager>(Context.CONNECTIVITY_SERVICE)

fun Context.windowManager() =
        getService<WindowManager>(Context.WINDOW_SERVICE)


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
inline fun <reified T> Context.getService(name: String): T = getSystemService(name) as T
