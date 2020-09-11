package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lesson(
        val orderKey: Int,
        val imageUrl: String = "",
        val body: String = "",
        val codeSnippet: CodeSnippet?,
        val type: Int
) : Parcelable {

    constructor() : this(
            0, "", "", null, LessonTypes.TEXT.ordinal)
}
