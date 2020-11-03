package com.olabode.wilson.pytutor.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Environment
import android.util.DisplayMetrics
import android.view.Display
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 *   Created by OLABODE WILSON on 9/27/20.
 */
object Utils {
    private const val NO_STARS = 3

    @Throws(IOException::class)
    fun createImageFile(context: Context): File? {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image: File = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",  /* suffix */
                storageDir /* directory */
        )
        return image
    }

    fun getAdapterNumberLabel(position: Int): String {
        if (position in 0..9) {
            return "0$position"
        }
        return position.toString()
    }


    fun calculateRating(score: Float, numberOfQuestions: Float): Float {
        // Convert score to star rating
        val maxRating = NO_STARS
        return maxRating / numberOfQuestions * score
    }


    fun getWidth(context: Context, activity: Activity): Int {
        var width: Int = 0
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val displayMetrics = DisplayMetrics()
            val display: Display? = context.display
            display!!.getRealMetrics(displayMetrics)
            displayMetrics.widthPixels
        } else {
            val displayMetrics = DisplayMetrics()
            activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
            width = displayMetrics.widthPixels
            width
        }
    }
}