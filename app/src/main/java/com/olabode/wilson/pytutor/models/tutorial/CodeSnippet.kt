package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CodeSnippet(
        val header: String,
        val code: String,
        val footer: String
) : Parcelable {

    constructor() : this(
            "", "", ""
    )
}
