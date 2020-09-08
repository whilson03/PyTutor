package com.olabode.wilson.pytutor.models.tutorial

import androidx.recyclerview.widget.DiffUtil

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
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TopicResponse>() {
            override fun areItemsTheSame(oldItem: TopicResponse, newItem: TopicResponse): Boolean {
                return oldItem.topicId == newItem.topicId
            }

            override fun areContentsTheSame(oldItem: TopicResponse, newItem: TopicResponse): Boolean {
                return oldItem == newItem
            }

        }
    }
}