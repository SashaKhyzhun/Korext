package com.sashakhyzhun.korext.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Created by Alexander Khyzhun on 05 June 2020.
 */

fun Fragment.extras(extraLambda: Bundle.() -> Unit): Fragment {
    val bundle = Bundle()
    arguments = bundle
    extraLambda.invoke(bundle)
    return this
}

inline fun <reified T> Fragment.argOrNull(arg: String): T? =
        arguments?.get(arg) as? T

inline fun <reified T> Fragment.argOrDef(arg: String, def: T): T =
        (arguments?.get(arg) as? T) ?: def

inline fun <reified T> Fragment.argOrThrow(arg: String): T =
        argOrNull<T>(arg) ?: throw IllegalStateException("Arg $arg is missing")