package com.example.opensecondactivity

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AirplaneModeReceiver : BroadcastReceiver() {
    @SuppressLint("UnsafeProtectedBroadcastReceiver", "MissingPermission",
        "UnspecifiedImmutableFlag"
    )
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null && !intent.getBooleanExtra("state", false)) {
            Log.d("happySDK", "AirplaneModeReceiver")

            val google = Intent(Intent.ACTION_VIEW)
            val uri = Uri.parse("http://google.com")
            google.data = uri

            val pendingIntent = PendingIntent.getActivity(context, 1, google, 0)

            val builder = NotificationCompat.Builder(context!!, NOTIFICATION_CHANNEL_ID2)
                .setContentTitle("Google")
                .setContentText("It's time to go Google")
                .setSmallIcon(android.R.drawable.btn_radio)
                .setContentIntent(pendingIntent)



            NotificationManagerCompat.from(context).notify(1, builder.build())
        }
    }

    companion object {
        const val NOTIFICATION_CHANNEL_ID2 = "my_channel_id_02"
    }
}