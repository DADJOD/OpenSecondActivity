package com.example.opensecondactivity

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyReceiver : BroadcastReceiver() {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {
        val myIntent = Intent(context, MyService::class.java)
        myIntent.putExtra(MyService.SERVICE_DATA_EXTRA, "from broadcast receiver")
        context?.startService(myIntent)
    }
}