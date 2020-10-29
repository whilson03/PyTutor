package com.olabode.wilson.pytutor.extensions

import android.animation.ObjectAnimator
import android.view.View
import android.widget.RatingBar
import androidx.core.view.isVisible

/**
 *   Created by OLABODE WILSON on 10/8/20.
 */

fun View.hide() {
    this.isVisible = false
}

fun View.show() {
    this.isVisible = true
}

fun View.enableClick() {
    this.isEnabled = true
}

fun View.disableClick() {
    this.isEnabled = false
}

fun RatingBar.showAndAnimateRating(value: Float) {
    val anim = ObjectAnimator.ofFloat(this, "rating", this.rating, value)
    anim.duration = 2000
    anim.start()
}

