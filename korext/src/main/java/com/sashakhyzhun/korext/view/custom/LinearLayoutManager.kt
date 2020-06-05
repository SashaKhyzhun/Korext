package com.sashakhyzhun.korext.view.custom

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * Created by Alexander Khyzhun on 03 February 2019.
 * All rights reserved.
 */
class LinearLayoutManager(context: Context) : LinearLayoutManager(context) {

    private var isScrollEnabled = true

    fun setScrollEnabled(flag: Boolean) {
        this.isScrollEnabled = flag
    }

    override fun canScrollVertically(): Boolean {
        return isScrollEnabled && super.canScrollVertically()
    }

}
