package com.sashakhyzhun.korext.view

import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * Created by Alexander Khyzhun on 03 February 2019.
 * All rights reserved.
 */
fun TextView.underline() {
    val content = SpannableString(this.text)
    content.setSpan(UnderlineSpan(), 0, content.length, 0)
    this.text = content
}

fun TextView.addHighlightSpan(textToHighlight: String) {
    val initialText = text
    val wordToSpan = SpannableString(text)
    var ofe = initialText.indexOf(textToHighlight, 0, true)
    var ofs = 0
    while (ofs < initialText.length && ofe != -1) {
        ofe = initialText.indexOf(textToHighlight, ofs, true)
        if (ofe == -1)
            break
        else {
            wordToSpan.setSpan(
                    BackgroundColorSpan(-0x100),
                    ofe,
                    ofe + textToHighlight.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        ofs = ofe + 1
    }
    setText(wordToSpan, TextView.BufferType.SPANNABLE)
}

fun TextView.removeSpan() {
    with(SpannableString(text)) {
        getSpans(0, 0, Object::class.java).forEach {
            removeSpan(it)
        }
    }
    invalidate()
}

fun TextView.textColor(@ColorRes color: Int) {
    this.setTextColor(
        ContextCompat.getColor(
            context,
            color
        )
    )
}