package com.example.sunmusic.utils

import android.util.Log
import com.example.sunmusic.BuildConfig

fun logDebugSunMusicApp(message: String, throwable: Throwable? = null) {
    Log.d("###${BuildConfig.APPLICATION_ID}", message, throwable)
}