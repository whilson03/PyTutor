package com.olabode.wilson.pytutor.extensions

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import com.olabode.wilson.pytutor.R

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


fun ProgressBar.showUserProgress(progress: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        this.setProgress(progress, false)
    } else {
        this.progress = progress
    }
}

fun View.setUpAnimation(context: Context) {
    val anim = AnimationUtils.loadAnimation(context, R.anim.splash_screen_logo_animation)
    this.animation = anim
}

fun EditText.getInput(): String = text.toString().trim()

fun noEmptyField(vararg editTexts: EditText): Boolean {
    return editTexts.filter { !TextUtils.isEmpty(it.text) }.size == editTexts.size
}

fun View.snack(
        @StringRes messageRes: Int,
        length: Int = Snackbar.LENGTH_LONG
) {
    snack(resources.getString(messageRes), length)
}

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}

//fun Snackbar.action(@StringRes actionRes: Int, color: Int? = null, listener: (View) -> Unit) {
//    action(view.resources.getString(actionRes), color, listener)
//}
//
//fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
//    setAction(action, listener)
//    color?.let { setActionTextColor(ContextCompat.getColor(context, color)) }
//}

fun View.showPersistentSnackBar(message: String, action: String, listener: () -> Unit) {
    Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE)
            .setAction(action) {
                listener.invoke()
            }.show()
}


fun Activity.displayToast(@StringRes message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.displayToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
