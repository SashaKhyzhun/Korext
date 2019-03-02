package com.sashakhyzhun.androidcommonutils.context

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.annotation.TargetApi
import android.app.*
import android.app.job.JobScheduler
import android.app.usage.NetworkStatsManager
import android.hardware.SensorManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.*
import android.os.storage.StorageManager
import android.telephony.CarrierConfigManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.view.WindowManager


/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */


/**
 * Returns InputMethodManager
 *
 * @return instance of InputMethodManager
 *
 * @see Context.getSystemService
 * @see Context.INPUT_METHOD_SERVICE
 * @see InputMethodManager
 */
fun Context.inputMethodService() =
    getService<InputMethodManager>(Context.INPUT_METHOD_SERVICE)

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
