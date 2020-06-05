package com.sashakhyzhun.korext.utils

import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.telephony.TelephonyManager

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */

fun isConnectedToWifi(connectivityManager: ConnectivityManager): Boolean {
    val info: NetworkInfo = connectivityManager.activeNetworkInfo
    return info.isConnected && info.type == ConnectivityManager.TYPE_WIFI
}


fun isConnectedToMobileData(
    connectivityManager: ConnectivityManager,
    telephonyManager: TelephonyManager
): Boolean {

    val info: NetworkInfo = connectivityManager.activeNetworkInfo
    val isRoaming = telephonyManager.isNetworkRoaming
    return info.isConnected && info.type == ConnectivityManager.TYPE_MOBILE && isRoaming.not()
}


/**
 * To get device consuming netowkr type is 2g,3g,4g
 *
 * @param context
 * @return "2g","3g","4g" as a String based on the network type
 */
fun getNetworkTypeG(networkType: Int?): String {
    when (networkType) {
        TelephonyManager.NETWORK_TYPE_GPRS,
        TelephonyManager.NETWORK_TYPE_EDGE,
        TelephonyManager.NETWORK_TYPE_CDMA,
        TelephonyManager.NETWORK_TYPE_1xRTT,
        TelephonyManager.NETWORK_TYPE_IDEN -> return "2g"

        /**
         * From this link https://en.wikipedia.org/wiki/Evolution-Data_Optimized ..NETWORK_TYPE_EVDO_0 & NETWORK_TYPE_EVDO_A
         * EV-DO is an evolution of the CDMA2000 (IS-2000) standard that supports high data rates.
         *
         * Where CDMA2000 https://en.wikipedia.org/wiki/CDMA2000 .CDMA2000 is a family of 3G[1] mobile technology standards for sending voice,
         * data, and signaling data between mobile phones and cell sites.
         */
        TelephonyManager.NETWORK_TYPE_UMTS,
        TelephonyManager.NETWORK_TYPE_EVDO_0,
        TelephonyManager.NETWORK_TYPE_EVDO_A,
        TelephonyManager.NETWORK_TYPE_HSDPA,
        TelephonyManager.NETWORK_TYPE_HSUPA,
        TelephonyManager.NETWORK_TYPE_HSPA,
        TelephonyManager.NETWORK_TYPE_EVDO_B,
        TelephonyManager.NETWORK_TYPE_EHRPD,
        TelephonyManager.NETWORK_TYPE_HSPAP ->
            //Log.d("Type", "3g");
            //For 3g HSDPA , HSPAP(HSPA+) are main  networktype which are under 3g Network
            //But from other constants also it will 3g like HSPA,HSDPA etc which are in 3g case.
            //Some cases are added after  testing(real) in device with 3g enable data
            //and speed also matters to decide 3g network type
            //https://en.wikipedia.org/wiki/4G#Data_rate_comparison
            return "3g"
        TelephonyManager.NETWORK_TYPE_LTE ->
            //No specification for the 4g but from wiki
            //I found(LTE (Long-Term Evolution, commonly marketed as 4G LTE))
            //https://en.wikipedia.org/wiki/LTE_(telecommunication)
            return "4g"

        else -> return "NotFound"
    }
}


fun getNetworkType(networkType: Int?): String {
    when (networkType) {
        TelephonyManager.NETWORK_TYPE_1xRTT -> return "1xRTT"
        TelephonyManager.NETWORK_TYPE_CDMA -> return "CDMA"
        TelephonyManager.NETWORK_TYPE_EDGE -> return "EDGE"
        TelephonyManager.NETWORK_TYPE_EHRPD -> return "eHRPD"
        TelephonyManager.NETWORK_TYPE_EVDO_0 -> return "EVDO rev. 0"
        TelephonyManager.NETWORK_TYPE_EVDO_A -> return "EVDO rev. A"
        TelephonyManager.NETWORK_TYPE_EVDO_B -> return "EVDO rev. B"
        TelephonyManager.NETWORK_TYPE_GPRS -> return "GPRS"
        TelephonyManager.NETWORK_TYPE_HSDPA -> return "HSDPA"
        TelephonyManager.NETWORK_TYPE_HSPA -> return "HSPA"
        TelephonyManager.NETWORK_TYPE_HSPAP -> return "HSPA+"
        TelephonyManager.NETWORK_TYPE_HSUPA -> return "HSUPA"
        TelephonyManager.NETWORK_TYPE_IDEN -> return "iDen"
        TelephonyManager.NETWORK_TYPE_LTE -> return "LTE"
        TelephonyManager.NETWORK_TYPE_UMTS -> return "UMTS"
        TelephonyManager.NETWORK_TYPE_UNKNOWN -> return "Unknown"
    }
    return "New type of network"
}