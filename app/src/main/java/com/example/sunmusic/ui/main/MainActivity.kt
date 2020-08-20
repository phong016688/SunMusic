package com.example.sunmusic.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sunmusic.R
import com.example.sunmusic.data.repository.AlbumRepositoryImpl
import com.example.sunmusic.ui.main.firstfragment.FirstFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main), MainContract.View {

    override var presenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(AlbumRepositoryImpl.instance)
        setSupportActionBar(toolbar)
        setupFragment()
    }

    override fun onDestroy() {
        presenter = null
        super.onDestroy()
    }

    override fun onGetAlbumSuccess() {
        //show list album
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
    }

    override fun onGetAlbumError() {
        // show error
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, FirstFragment.newInstance(), FirstFragment.TAG)
            .commit()
    }

    companion object {
        val TAG = this::class.java.simpleName
        fun getInstance(): MainActivity {
            return MainActivity()
        }
    }
}