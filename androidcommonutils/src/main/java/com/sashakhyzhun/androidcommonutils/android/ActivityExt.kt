package com.sashakhyzhun.androidcommonutils.android

import android.annotation.TargetApi
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */

fun Activity.showKeyboard() {
    val view = currentFocus
    if (view != null) {
        inputMethodService().showSoftInput(
            view,
            InputMethodManager.SHOW_IMPLICIT
        )
    }
}

fun Activity.hideKeyboard() {
    val view = currentFocus
    if (view != null) {
        inputMethodService().hideSoftInputFromWindow(
            view.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.hideStatusBar() {
    val decor = window.decorView
    decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    window.statusBarColor = Color.TRANSPARENT
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setStatusBarColor(colorRes: Int) {
    window.statusBarColor = resources.getColor(colorRes)
}