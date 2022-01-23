package com.namanh.interview.file

import java.io.File
import java.io.FileOutputStream

class FileHelperImpl(private val directory: File) : FileHelper {

    override fun saveData(fileName: String, data: String) {
        val file = buildFile(fileName)
        val fileOutputStream = buildOutputStream(file)
        try {
            fileOutputStream.use {
                it.write(data.toByteArray())
            }
        } catch (error: Throwable) {
            error.printStackTrace()
        }
    }

    override fun getData(): List<File> =
        directory.listFiles()?.toList() ?: emptyList()

    override fun deleteData(fileName: String) {
        TODO("Not yet implemented")
    }

    private fun buildFile(fileName: String) : File {
        return File(directory, fileName)
    }

    private fun buildOutputStream(file: File) : FileOutputStream {
        return FileOutputStream(file)
    }
}