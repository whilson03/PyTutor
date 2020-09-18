package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */
@Entity(tableName = "Topics_table")
@Parcelize
data class TopicResponse(
        @ColumnInfo(name = "order_key")
        val orderKey: Int,

        @ColumnInfo(name = "title")
        val title: String,

        @ColumnInfo(name = "description")
        val description: String,

        @ColumnInfo(name = "pages_count")
        val noOfPages: Int,

        @ColumnInfo(name = "topic_id")
        var topicId: String,

        @ColumnInfo(name = "is_locked")
        val isLocked: Boolean,

        @ColumnInfo(name = "is_completed")
        val isCompleted: Boolean
) : Parcelable {

    constructor() : this(
            0, "", "", 0, "", true, true
    )

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