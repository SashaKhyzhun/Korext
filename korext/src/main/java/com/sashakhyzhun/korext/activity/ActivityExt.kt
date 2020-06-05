package com.sashakhyzhun.korext.activity

import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.sashakhyzhun.korext.context.inputMethodManager


fun Activity.showKeyboard() {
	currentFocus?.let {
        inputMethodManager?.showSoftInput(
            it,
            InputMethodManager.SHOW_IMPLICIT
        )
	}
}

fun Activity.hideKeyboard() {
	currentFocus?.let {
        inputMethodManager?.hideSoftInputFromWindow(
            it.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
	}
}

fun Activity.startActivityChildFree(intent: Intent) {
	this.startActivity(intent).also { this.finishAffinity() }
}

fun Activity.disableClicks() {
	this.window.setFlags(
		WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
		WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
	)
}

fun Activity.enableClicks() {
	this.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.hideStatusBar() {
	val decor = window.decorView
    decor.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
	window.statusBarColor = Color.TRANSPARENT
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setStatusBarColor(colorRes: Int) {
	window.statusBarColor = resources.getColor(colorRes)
}