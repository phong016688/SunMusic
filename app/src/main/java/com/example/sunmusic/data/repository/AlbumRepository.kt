package com.example.sunmusic.data.repository

import android.content.SharedPreferences
import com.example.sunmusic.domain.repository.AlbumRepository

class AlbumRepositoryImpl private constructor() : AlbumRepository {
    companion object {
        val instance by lazy(LazyThreadSafetyMode.NONE) { AlbumRepositoryImpl() }
    }
}