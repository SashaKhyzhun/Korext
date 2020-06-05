package com.sashakhyzhun.korext.view

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat

/**
 * Created by Alexander Khyzhun on 03 February 2019.
 * All rights reserved.
 */

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context)
        .inflate(layoutId, this, attachToRoot)

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

fun View.collapse(coefficient: Long = 5L) {
    val initialHeight = this.measuredHeight
    val a = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
            if (interpolatedTime == 1f) {
                this@collapse.visibility = View.GONE
            } else {
                this@collapse.layoutParams.height = initialHeight - (initialHeight * interpolatedTime).toInt()
                this@collapse.requestLayout()
            }
        }
        override fun willChangeBounds(): Boolean = true
    }
    // Collapse speed of 1dp/ms [~123 ms default]
    a.duration = (initialHeight / this.context.resources.displayMetrics.density).toInt().toLong() * coefficient
    this.startAnimation(a)
}

fun View.expand(coefficient: Long = 5L) {
    val matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec((this.parent as View).width, View.MeasureSpec.EXACTLY)
    val wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    this.measure(matchParentMeasureSpec, wrapContentMeasureSpec)
    val targetHeight = this.measuredHeight

    // Older versions of android (pre API 21) cancel animations for views with a height of 0.
    this.layoutParams.height = 1
    this.visibility = View.VISIBLE
    val a = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
            this@expand.layoutParams.height = if (interpolatedTime == 1f) {
                ViewGroup.LayoutParams.WRAP_CONTENT
            } else {
                (targetHeight * interpolatedTime).toInt()
            }
            this@expand.requestLayout()
        }

        override fun willChangeBounds(): Boolean = true
    }

    // Expansion speed of 1dp/ms
    a.duration = (targetHeight / this.context.resources.displayMetrics.density).toInt().toLong() * coefficient
    this.startAnimation(a)
}

fun View.setTint(@ColorRes color: Int = android.R.color.white) {
    this.background.setColorFilter(
        ContextCompat.getColor(
            context,
            color
        ),
        PorterDuff.Mode.SRC_IN
    )
}

fun View.setBorder(@DrawableRes id: Int) {
    this.background = ContextCompat.getDrawable(
        context,
        id
    )
}


