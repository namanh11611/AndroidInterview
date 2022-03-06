package com.namanh.interview.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.*

class BoundService : Service() {

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    inner class LocalBinder : Binder() {
        // Return this instance of BoundService so clients can call public methods
        fun getService(): BoundService = this@BoundService
    }

    private var binder = LocalBinder()
    private val mGenerator = Random()

    /** Method for clients */
    val randomNumber: Int
        get() = mGenerator.nextInt(100)

    override fun onBind(intent: Intent?): IBinder? {
        Log.d("henzy", "BoundService onBind")
        return binder
    }
}