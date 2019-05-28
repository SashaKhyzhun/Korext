package com.sashakhyzhun.androidcommonutils.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat

/**
 * @author SashaKhyzhun
 * Created on 3/2/19.
 */

fun Context.sendNotification(
    intent: Intent,
    image: Int,
    title: String,
    description: String
) {
    val nm = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK


    val mIcon = BitmapFactory.decodeResource(this.resources, image)
    val pIntent = PendingIntent.getActivity(
        this,
        5555,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )
    val notificationBuilder = NotificationCompat.Builder(
        this,
        "AndroidCommonUtilsChannel"
    )

    notificationBuilder.setSmallIcon(image)

    when (Build.VERSION.SDK_INT) {
        in 21..23 -> {
            notificationBuilder
                .setSmallIcon(image)
                .setContentTitle(title)
                .setContentText(description)
        }
        in 24..25 -> {
            notificationBuilder
                .setLargeIcon(mIcon)
                .setContentTitle(title)
                .setContentText(description)
        }
        in 26..27 -> {
            notificationBuilder
                .setLargeIcon(mIcon)
                .setContentTitle(title)
                .setContentText(description)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel = NotificationChannel(
                    "AndroidCommonUtilsChannelId",
                    "AndroidCommonUtilsChannelName",
                    NotificationManager.IMPORTANCE_HIGH
                )

                with(notificationChannel) {
                    enableLights(true)
                    lightColor = Color.RED
                    enableVibration(false)
                }

                notificationBuilder.setChannelId("10001")
                nm.createNotificationChannel(notificationChannel)
            }

        }
    }

    notificationBuilder.setContentIntent(pIntent)
        //.setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE)
        .setLights(Color.BLUE, 1000, 1500)
        .setAutoCancel(true)
        .setWhen(System.currentTimeMillis())

    nm.notify(123, notificationBuilder.build())

}