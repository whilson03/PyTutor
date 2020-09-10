package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/10/20.
 */

@Parcelize
data class Question(
        val question: String
) : Parcelable