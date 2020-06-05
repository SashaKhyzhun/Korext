package com.sashakhyzhun.korext.activity

import android.annotation.TargetApi
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.sashakhyzhun.korext.context.inputMethodService



fun Activity.showKeyboard() {
    currentFocus?.let {
        inputMethodService?.showSoftInput(it, InputMethodManager.SHOW_IMPLICIT)
    }
}

fun Activity.hideKeyboard() {
    currentFocus?.let {
        inputMethodService?.hideSoftInputFromWindow(
                it.windowToken,
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