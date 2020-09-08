package com.olabode.wilson.pytutor.models.tutorial

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */

data class TopicResponse(
        val orderKey: Int,
        val Title: String,
        val description: String,
        val noOfPages: Int,
        val topicId: String,
        val isLocked: Boolean,
        val isCompleted: Boolean
)