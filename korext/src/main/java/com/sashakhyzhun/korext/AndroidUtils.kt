package com.sashakhyzhun.korext

import android.os.Build
import com.sashakhyzhun.korext.utils.empty

/**
 * Created by Alexander Khyzhun on 05 June 2020.
 */



fun androidVersionName(): String? {
	var name = empty()
	for (field in Build.VERSION_CODES::class.java.fields) {
		val fieldName = field.name
		var fieldValue = -1

		try {
			fieldValue = field.getInt(Any())
		} catch (e: IllegalArgumentException) {
			e.printStackTrace()
		} catch (e: IllegalAccessException) {
			e.printStackTrace()
		} catch (e: NullPointerException) {
			e.printStackTrace()
		}

		if (fieldValue == Build.VERSION.SDK_INT) {
			name = fieldName
			break
		}
	}
	return name
}