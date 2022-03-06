package com.namanh.interview

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.Toast
import com.namanh.interview.service.BoundService
import com.namanh.interview.service.ForegroundService

class MainActivity : AppCompatActivity() {

    private lateinit var mService: BoundService
    private var mBound: Boolean = false

    /** Defines callbacks for service binding, passed to bindService()  */
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // We've bound to BoundService, cast the IBinder and get LocalService instance
            val binder = service as BoundService.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.bt_start_service)
        val stopButton = findViewById<Button>(R.id.bt_stop_service)
        val bindButton = findViewById<Button>(R.id.bt_random)

        val intent = Intent(this, ForegroundService::class.java)
        startButton.setOnClickListener {
            // Start foreground service
            startService(intent)
        }
        stopButton.setOnClickListener {
            stopService(intent)
        }

        bindButton.setOnClickListener {
            if (mBound) {
                val num: Int = mService.randomNumber
                Toast.makeText(this, "Result: $num from bound service", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        // Bind to BoundService
        Intent(this, BoundService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()

        // Unbind BoundService
        unbindService(connection)
        mBound = false
    }
}