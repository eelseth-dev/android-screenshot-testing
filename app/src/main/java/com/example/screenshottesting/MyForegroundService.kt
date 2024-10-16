package com.example.screenshottesting

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.twilio.sync.client.SyncClient
import com.twilio.sync.utils.LogLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MyForegroundService : Service() {

    val scope = CoroutineScope(Job() + Dispatchers.Main)

    var syncClient: SyncClient? = null

    override fun onBind(intent: Intent?): IBinder? {
        // Return null because it's not a bound service.
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Start the service in the foreground.
        startForegroundService()
        Log.i("algarzam", "Service created")
        SyncClient.setLogLevel(LogLevel.Debug)
        scope.launch {
            
        }

        return START_NOT_STICKY
    }

    private fun startForegroundService() {
        // Create a notification channel for Android 8.0 and higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "ForegroundServiceChannel"
            val channel = NotificationChannel(
                channelId, "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }

        // Create a notification for the service
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, "ForegroundServiceChannel")
            .setContentTitle("Foreground Service")
            .setContentText("Service is running in the foreground")
            //.setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()

        // Start the service in the foreground with the notification
        startForeground(1, notification)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("algarzam", "Serice destroyed")
        // Handle cleanup if needed
        stopForeground(STOP_FOREGROUND_REMOVE)
    }
}
