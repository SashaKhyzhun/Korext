package com.sashakhyzhun.androidcommonutils.converter

import android.content.res.Resources
import android.R.attr.y
import android.os.Build
import android.content.Context.WINDOW_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.view.WindowManager
import android.R.attr.x
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Point
import com.sashakhyzhun.androidcommonutils.android.windowManager
import androidx.core.content.ContextCompat.getSystemService

/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */



/**
 * Converts value to dp analog according to phones density
 */
val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

/**
 * Converts value to px analog according to phones density
 */
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

/**
 * Converts value to dp analog according to phones density
 */
val Float.dp: Float
    get() = this / Resources.getSystem().displayMetrics.density

/**
 * Converts value to px analog according to phones density
 */
val Float.px: Float
    get() = this * Resources.getSystem().displayMetrics.density




/**
 * @return the width of screen, in pixel
 */
@SuppressLint("ObsoleteSdkInt")
fun getScreenWidth(ctx: Context): Int {
    val wm = ctx.windowManager()
    val point = Point()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        wm.defaultDisplay.getRealSize(point)
    } else {
        wm.defaultDisplay.getSize(point)
    }
    return point.x
}

/**
 * @return the height of screen, in pixel
 */
@SuppressLint("ObsoleteSdkInt")
fun getScreenHeight(ctx: Context): Int {
    val wm = ctx.windowManager()
    val point = Point()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        wm.defaultDisplay.getRealSize(point)
    } else {
        wm.defaultDisplay.getSize(point)
    }
    return point.y
}
