package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/10/20.
 */

@Parcelize
data class Question(
        val question: String,
        val options: Map<Int, String>,
        val answerKey: Int
) : Parcelable {
    constructor() : this(
            "", mapOf(0 to ""), 0
    )
}