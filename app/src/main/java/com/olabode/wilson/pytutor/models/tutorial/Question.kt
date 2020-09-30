package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/10/20.
 */

@Parcelize
data class Question(
    val question: String,
    val options: Map<String, String>,
    val answerKey: String
) : Parcelable {
    constructor() : this(
        "", mapOf("" to ""), ""
    )
}