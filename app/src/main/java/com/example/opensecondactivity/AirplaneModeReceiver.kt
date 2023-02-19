package com.example.opensecondactivity

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AirplaneModeReceiver : BroadcastReceiver() {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("happySDK", "AirplaneModeReceiver")

        val newIntent = Intent(context, MyService::class.java)
        newIntent.putExtra(MyService.SERVICE_DATA_EXTRA, "AirplaneModeReceiver")
        context?.startService(newIntent)
    }
}