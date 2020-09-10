package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lesson(
        val imageUrl: String = "",
        val body: String = "",
        val codeSnippet: CodeSnippet?,
        val type: Int
) : Parcelable
