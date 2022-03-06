package com.namanh.interview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.namanh.interview.service.ForegroundService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.bt_start_service)
        val stopButton = findViewById<Button>(R.id.bt_stop_service)

        val intent = Intent(this, ForegroundService::class.java)
        startButton.setOnClickListener {
            // Start foreground service
            startService(intent)
        }
        stopButton.setOnClickListener {
            stopService(intent)
        }
    }
}