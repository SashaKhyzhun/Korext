package com.sashakhyzhun.androidcommonutils.collections

import android.util.Log
import com.sashakhyzhun.androidcommonutils.AndroidCommonUtils.TAG

/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */
class ConvertException(reason: String) : RuntimeException(reason)



fun <A> Iterable<A>.contains(predicate: (A) -> Boolean?): Boolean {
    this.forEach {
        if (predicate.invoke(it)!!) return true
    }
    return false
}

fun <T, R> maybeConvert(item: T?, converter: (T) -> R): R? =
    if (item != null) {
        try {
            converter.invoke(item)
        } catch (e: ConvertException) {
            Log.d(TAG, e.message)
            null
        }
    } else {
        null
    }

fun <E, T> Iterable<E>.mapOrSkip(convertFun: (E) -> T?): List<T> {
    val mutableList = mutableListOf<T>()
    this
        .map { maybeConvert(it, convertFun) }
        .forEach { value ->
            value?.let {
                mutableList.add(it)
            }
        }
    return mutableList
}

fun <K, V> MutableMap<K, V>.removeOrAdd(key: K, value: V) {
    when (this.containsKey(key)) {
        true -> this.remove(key)
        false -> this.put(key, value)
    }
}
