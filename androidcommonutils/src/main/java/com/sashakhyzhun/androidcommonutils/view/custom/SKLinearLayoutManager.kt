package com.sashakhyzhun.androidcommonutils.view.custom

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * @author SashaKhyzhun
 * Created on 3/1/19.
 */
class SKLinearLayoutManager(context: Context) : LinearLayoutManager(context) {

    private var isScrollEnabled = true

    fun setScrollEnabled(flag: Boolean) {
        this.isScrollEnabled = flag
    }

    override fun canScrollVertically(): Boolean {
        return isScrollEnabled && super.canScrollVertically()
    }

}
