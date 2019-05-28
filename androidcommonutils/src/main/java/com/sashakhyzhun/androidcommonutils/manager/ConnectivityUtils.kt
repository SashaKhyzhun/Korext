package com.sashakhyzhun.androidcommonutils.manager

import android.Manifest.permission.ACCESS_NETWORK_STATE
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import androidx.annotation.RequiresPermission
import com.sashakhyzhun.androidcommonutils.android.connectivityManager


/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */

enum class NetworkType {
    NETWORK_ETHERNET,
    NETWORK_WIFI,
    NETWORK_4G,
    NETWORK_3G,
    NETWORK_2G,
    NETWORK_UNKNOWN,
    NETWORK_NO
}

/**
 * Open the settings of wireless.
 */
fun openWirelessSettings(ctx: Context) {
    ctx.startActivity(
            Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    )
}

/**
 * Return whether network is connected.
 * Must hold `<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />`
 * @return `true`: connected<br></br>`false`: disconnected
 */
@RequiresPermission(ACCESS_NETWORK_STATE)
fun Context.isConnected(): Boolean {
    val info = this.connectivityManager().activeNetworkInfo
    return info != null && info.isConnected
}

/**
 * To get device consuming netowkr type is 2g,3g,4g
 *
 * @param context
 * @return "2g","3g","4g" as a String based on the network type
 */
@RequiresPermission(ACCESS_NETWORK_STATE)
fun Context.getNetworkType(): NetworkType {
    val info = this.connectivityManager().activeNetworkInfo
    info?.let {

        when (info.subtype) {
            TelephonyManager.NETWORK_TYPE_GSM,
            TelephonyManager.NETWORK_TYPE_GPRS,
            TelephonyManager.NETWORK_TYPE_CDMA,
            TelephonyManager.NETWORK_TYPE_EDGE,
            TelephonyManager.NETWORK_TYPE_1xRTT,
            TelephonyManager.NETWORK_TYPE_IDEN ->
                return NetworkType.NETWORK_2G

            TelephonyManager.NETWORK_TYPE_TD_SCDMA,
            TelephonyManager.NETWORK_TYPE_EVDO_A,
            TelephonyManager.NETWORK_TYPE_UMTS,
            TelephonyManager.NETWORK_TYPE_EVDO_0,
            TelephonyManager.NETWORK_TYPE_HSDPA,
            TelephonyManager.NETWORK_TYPE_HSUPA,
            TelephonyManager.NETWORK_TYPE_HSPA,
            TelephonyManager.NETWORK_TYPE_EVDO_B,
            TelephonyManager.NETWORK_TYPE_EHRPD,
            TelephonyManager.NETWORK_TYPE_HSPAP ->
                return NetworkType.NETWORK_3G

            TelephonyManager.NETWORK_TYPE_IWLAN,
            TelephonyManager.NETWORK_TYPE_LTE ->
                return NetworkType.NETWORK_4G

            else -> {
                val subtypeName = info.subtypeName
                if (subtypeName.equals("TD-SCDMA", ignoreCase = true)
                        || subtypeName.equals("WCDMA", ignoreCase = true)
                        || subtypeName.equals("CDMA2000", ignoreCase = true)) {
                    return NetworkType.NETWORK_3G
                }
            }

        }
    }

    return NetworkType.NETWORK_UNKNOWN
}