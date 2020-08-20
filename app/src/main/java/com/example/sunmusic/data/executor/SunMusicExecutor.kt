package com.example.sunmusic.data.executor

import com.example.sunmusic.BuildConfig
import com.example.sunmusic.domain.executor.SunMusicExecutor
import com.example.sunmusic.utils.logDebugSunMusicApp
import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory

class SunMusicExecutorImpl private constructor() : Executor, SunMusicExecutor {
    private val mExecutor = Executors.newFixedThreadPool(N_THREAD, MyThreadFactory())

    companion object {
        const val N_THREAD = 5
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { SunMusicExecutorImpl() }
    }

    override fun execute(p0: Runnable?) {
        mExecutor.execute(p0)
        logDebugSunMusicApp(p0?.toString() ?: "")
    }

    override fun executes(vararg runnables: Runnable?) {
        runnables.forEach { execute(it) }
    }

    class MyThreadFactory : ThreadFactory {
        private var count = 0
        override fun newThread(p0: Runnable?): Thread {
            return Thread(p0, "${BuildConfig.APPLICATION_ID} - Thread - ${count++}")
        }
    }
}