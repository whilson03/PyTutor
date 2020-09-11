package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CodeSnippet(
        val footer: String,
        val code: String,
        val header: String
) : Parcelable {

    constructor() : this(
            "", "", ""
    )
}
