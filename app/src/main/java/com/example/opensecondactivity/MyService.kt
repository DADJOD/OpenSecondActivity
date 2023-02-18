package com.example.opensecondactivity

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

@Suppress("DEPRECATION")
class MyService : Service() {
    private var data: String? = null
    private var counter = 0
    private val handler = Handler() // queue

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("happySDK", "MyService onCreate")

        kotlin.run {
            Log.d("happySDK", "my run kotlin.run")
        }

        doSomething()
    }

    // looper
    private fun doSomething() {
        Log.d("happySDK", "doSomething")
        counter++
        showNotification()

        val myRunnable = Runnable {
            doSomething()
        }

        handler.postDelayed(myRunnable, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("happySDK", "MyService onDestroy")

//        handler.removeCallbacksAndMessages(null)   // stops the queue of handler
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if (intent != null && intent.hasExtra(SERVICE_DATA_EXTRA)) {
            data = intent.getStringExtra(SERVICE_DATA_EXTRA)
            Log.d("happySDK", "MyService onStartCommand $counter $data")
        }

        return START_STICKY // return service if it is deleted in memory
//        return super.onStartCommand(intent, flags, startId)
    }

    @SuppressLint("MissingPermission", "WrongConstant", "UnspecifiedImmutableFlag")
    private fun showNotification() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.INFO_EXTRA, "$data $counter")

        val pendingIntent = PendingIntent.getActivity(
            this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT
        )

        val builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        builder.setContentTitle("Wow!")
        builder.setContentText("$data $counter")
        builder.setSmallIcon(android.R.drawable.stat_sys_warning)
        builder.setContentIntent(pendingIntent)

        builder.addAction(android.R.drawable.ic_dialog_email, "MAIL", pendingIntent)
        builder.addAction(android.R.drawable.ic_menu_call, "CALL", pendingIntent)

        val notification = builder.build()
        val manager = NotificationManagerCompat.from(this)

        manager.notify(1, notification)
    }

    companion object {
        const val SERVICE_DATA_EXTRA = "data"
        const val NOTIFICATION_CHANNEL_ID = "my_channel_id_01"
    }











/*    private var counter = 0
    private val handler = Handler() // queue

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("happySDK", "MyService onCreate")

//        Runnable {
//            Log.d("happySDK", "my run")
//        }

//        val myRunnable = Runnable {
//            Log.d("happySDK", "my run")
//        }

//        myRunnable.run()

        kotlin.run {
            Log.d("happySDK", "my run kotlin.run")
        }

//        handler.post(myRunnable)
//        handler.postDelayed(myRunnable, 5000)
        doSomething()
    }

    // looper
    private fun doSomething() {
        Log.d("happySDK", "doSomething")

        val myRunnable = Runnable {
            doSomething()
        }

        handler.postDelayed(myRunnable, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("happySDK", "MyService onDestroy")

        handler.removeCallbacksAndMessages(null)   // stops the queue of handler
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        counter++

//        Log.d("happySDK", "MyService onStartCommand")

        if (intent != null && intent.hasExtra(SERVICE_DATA_EXTRA)) {
            val data = intent.getStringExtra(SERVICE_DATA_EXTRA)
            Log.d("happySDK", "MyService onStartCommand $counter $data")
        }

        stopSelf(startId)  // request to stop the service

//        return START_NOT_STICKY
//        return START_REDELIVER_INTENT
//        return super.onStartCommand(intent, flags, startId)
        return START_STICKY               // return service if it is deleted in memory
    }

    companion object {
        const val SERVICE_DATA_EXTRA = "data"
    }*/
}