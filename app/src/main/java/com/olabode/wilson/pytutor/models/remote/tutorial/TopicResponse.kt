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

        var locked: Boolean,

        var completed: Boolean,

        var stars: Float,

        val lastTopic: Boolean,

        var nextTopicId: String? = null
) {

    constructor() : this(
            0,
            "",
            "",
            0,
            "",
            true,
            true,
            0f,
            false,
            null
    )
}