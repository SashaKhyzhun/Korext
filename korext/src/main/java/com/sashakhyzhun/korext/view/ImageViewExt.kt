package com.sashakhyzhun.korext.view

import android.widget.ImageView
import androidx.annotation.DrawableRes

/**
 * Created by Alexander Khyzhun on 05 June 2020.
 */

fun ImageView.setSrc(@DrawableRes id: Int) {
	this.setImageResource(id)
}