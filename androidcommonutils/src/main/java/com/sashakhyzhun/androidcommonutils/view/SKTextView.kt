package com.sashakhyzhun.androidcommonutils.view

import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView

/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */
fun TextView.underline() {
    val content = SpannableString(this.text)
    content.setSpan(UnderlineSpan(), 0, content.length, 0)
    this.text = content
}