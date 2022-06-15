package com.example.hiltsample.logger

import android.util.Log
import javax.inject.Inject

interface Logger {

    fun d(message: String)

    fun e(message: String)
}

class LoggerImpl @Inject constructor(
    private val tag: String
) : Logger {

    override fun d(message: String) {
        Log.d(tag, message)
    }

    override fun e(message: String) {
        Log.e(tag, message)
    }
}