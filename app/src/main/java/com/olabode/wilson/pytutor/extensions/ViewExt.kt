package com.olabode.wilson.pytutor.extensions

import android.view.View
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