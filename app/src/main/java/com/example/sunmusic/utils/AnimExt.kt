package com.example.sunmusic.utils

import android.transition.*
import android.view.Gravity
import android.view.ViewGroup

fun ViewGroup.applyAnimationSlide() {
    val slide = Slide(Gravity.BOTTOM).apply {
        duration = 500
        startDelay = 100
    }
    TransitionManager.beginDelayedTransition(this, slide)
}

// using on recycler view
fun ViewGroup.applyAnimationExplode() {
    val explode = Explode().apply {
        duration = 500
        startDelay = 100
    }
    TransitionManager.beginDelayedTransition(this, explode)
}

// using on image
fun ViewGroup.applyAnimationChangeImage() {
    val transitionSet = TransitionSet().apply {
        addTransition(ChangeBounds())
        addTransition(ChangeImageTransform())
    }
    TransitionManager.beginDelayedTransition(this, transitionSet)
}