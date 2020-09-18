package com.olabode.wilson.pytutor.models.remote.tutorial

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */

@Parcelize
data class TopicResponse(

        val orderKey: Int,

        val title: String,

        val description: String,

        val noOfPages: Int,

        var topicId: String,

        val isLocked: Boolean,

        val isCompleted: Boolean
) : Parcelable {

    constructor() : this(
            0, "", "", 0, "", true, true
    )

}