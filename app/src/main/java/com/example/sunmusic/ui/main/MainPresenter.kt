package com.example.sunmusic.ui.main

import com.example.sunmusic.domain.repository.AlbumRepository
import kotlin.random.Random

class MainPresenter(private val albumRepository: AlbumRepository) : MainContract.Presenter {
    override var view: MainContract.View? = null

    override fun getAllAlbum() {
        // repository get all album
        val success = Random.nextBoolean()
        if (success) {
            view?.onGetAlbumSuccess()
        } else {
            view?.onGetAlbumError()
        }
    }
}