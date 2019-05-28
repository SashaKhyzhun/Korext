package com.sashakhyzhun.androidcommonutils.tuples

import java.io.Serializable

/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */

data class Triple<out A, out B, out C>(
    val first: A,
    val second: B,
    val third: C
) : Serializable

data class Quad<out A, out B, out C, out D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
) : Serializable

data class Quint<out A, out B, out C, out D, out E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E
) : Serializable