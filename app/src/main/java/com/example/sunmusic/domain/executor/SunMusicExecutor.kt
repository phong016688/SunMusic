package com.example.sunmusic.domain.executor

interface SunMusicExecutor{
    fun executes(vararg runnables: Runnable?)
}