package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */

@Parcelize
data class LessonResponse(
        val page: Int,
        val lessons: Map<Int, Lesson>
) : Parcelable
