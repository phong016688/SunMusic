package com.example.sunmusic.ui.main.secoundframent

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sunmusic.R
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.handleEvents()
    }

    private fun View.handleEvents() {
        button_second.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    companion object {
        val TAG = this::class.java.simpleName
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
}