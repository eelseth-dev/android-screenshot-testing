package com.example.screenshottesting

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MyLifecycleObserver : DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        // on Application Foreground
        Log.i("algarzam", "onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.i("algarzam", "onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        // on Application Background
        Log.i("algarzam", "onPause")
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.i("algarzam", "onCreate")

    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.i("algarzam", "onDestroy")
    }
}