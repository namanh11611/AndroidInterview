package com.namanh.interview

import android.app.Application
import com.namanh.interview.file.FileHelperImpl
import java.io.File

class MyApplication : Application() {

    companion object {
        private lateinit var app : MyApplication

        private val internalFileHelper by lazy {
            FileHelperImpl(app.filesDir) // Internal storage
        }

        private val externalFileHelper by lazy {
            FileHelperImpl(getFileDirectory()) // External storage
        }

        private fun getFileDirectory() : File {
            val directory = File(app.getExternalFilesDir(null), "")
            if (!directory.exists()) {
                directory.mkdirs()
            }
            return directory
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        internalFileHelper.saveData("InFile", "Test internal data")
        externalFileHelper.saveData("ExFile", "Test external data")
    }
}