package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */

@Parcelize
data class TopicResponse(
        val orderKey: Int,
        val Title: String,
        val description: String,
        val noOfPages: Int,
        val topicId: String,
        val isLocked: Boolean,
        val isCompleted: Boolean
) : Parcelable {
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