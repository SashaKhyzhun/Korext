package com.sashakhyzhun.korext.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.annotation.LayoutRes

/**
 * Created by Alexander Khyzhun on 03 February 2019.
 * All rights reserved.
 */

fun View.isAlphaZero() = alpha == 0f

fun View.isAlphaFull() = alpha == 1f

fun View.setGone() { this.visibility = View.GONE }

fun View.setVisible() { this.visibility = View.VISIBLE }

fun View.setInvisible() { this.visibility = View.INVISIBLE }

fun View.fadeInOrOut() { if (this.isAlphaZero()) { fadeIn() } else if (isAlphaFull()) { fadeOut() } }

fun View.fadeOut() {
    this.alpha = 1f
    this.animate().apply {
        interpolator = LinearInterpolator()
        duration = 200
        alpha(0f)
        start()
    }
}

fun View.fadeIn() {
    this.alpha = 0f
    this.animate().apply {
        interpolator = LinearInterpolator()
        duration = 200
        alpha(1f)
        start()
    }
}

fun View.visibleOrGone(isVisible: Boolean) = if (isVisible) this.setVisible() else this.setGone()

fun View.setMargins(left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        val p = layoutParams as ViewGroup.MarginLayoutParams
        p.setMargins(left, top, right, bottom)
        requestLayout()
    }
}

fun View.clearMargins() = setMargins()



fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context)
                .inflate(layoutId, this, attachToRoot)