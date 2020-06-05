package com.sashakhyzhun.korext.context

import android.app.NotificationManager
import android.app.job.JobScheduler
import android.content.Context
import android.view.inputmethod.InputMethodManager


/**
 * Returns InputMethodManager
 *
 * @return instance of InputMethodManager
 *
 * @see Context.getSystemService
 * @see Context.INPUT_METHOD_SERVICE
 * @see InputMethodManager
 */
inline val Context.jobScheduler: JobScheduler?
    get() = getSystemService(Context.JOB_SCHEDULER_SERVICE) as? JobScheduler

inline val Context.inputMethodManager: InputMethodManager?
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager

inline val Context.notificationManager: NotificationManager?
    get() = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager

/**
 * Returns class representing service with provided name
 *
 * @param[name] - name of the needed service
 *
 * @return instance of HardwarePropertiesManager
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 */
private inline fun <reified T> Context.getService(name: String): T = getSystemService(name) as T