package com.namanh.interview.file

import java.io.File

interface FileHelper {
    fun saveData(fileName: String, data: String)

    fun getData(): List<File>

    fun deleteData(fileName: String)
}