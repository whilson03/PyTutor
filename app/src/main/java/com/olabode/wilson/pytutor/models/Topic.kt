package com.olabode.wilson.pytutor.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

@Parcelize
data class Topic(
        val orderKey: Int,
        val title: String,
        val description: String,
        val noOfPages: Int,
        var topicId: String,
        var isLocked: Boolean,
        var isCompleted: Boolean,
        var numOfStars: Float = 0f
) : Parcelable {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Topic>() {
            override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
                return oldItem.topicId == newItem.topicId
            }

            override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
                return oldItem == newItem
            }

        }
    }
}