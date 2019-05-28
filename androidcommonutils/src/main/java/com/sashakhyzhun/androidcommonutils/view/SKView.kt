package com.sashakhyzhun.androidcommonutils.view

import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.TextView

/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */

fun View.setGone() {
    this.visibility = View.GONE
}

fun View.setVisible() {
    this.visibility = View.VISIBLE
}

fun View.setInvisible() {
    this.visibility = View.INVISIBLE
}