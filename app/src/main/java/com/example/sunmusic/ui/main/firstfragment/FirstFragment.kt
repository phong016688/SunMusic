package com.example.sunmusic.ui.main.firstfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sunmusic.R
import com.example.sunmusic.ui.main.secoundframent.SecondFragment
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.handleEvents()
    }

    private fun View.handleEvents() {
        button_first.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer,
                    SecondFragment.newInstance(),
                    SecondFragment.TAG
                )
                ?.addToBackStack(SecondFragment.TAG)
                ?.commit()
        }
    }

    companion object {
        val TAG = this::class.java.simpleName
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }
}