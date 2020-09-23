package com.olabode.wilson.pytutor.models.remote.tutorial

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */


data class TopicResponse(

        var orderKey: Int,

        var title: String,

        var description: String,

        var noOfPages: Int,

        var topicId: String,

        var isLocked: Boolean,

        var isCompleted: Boolean
) {

    constructor() : this(
            0, "", "", 0, "", true, true
    )

}