package com.olabode.wilson.pytutor.models.cache.tutorial

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */
@Entity(tableName = "Topics_table")
data class TopicCacheEntity(

        @ColumnInfo(name = "order_key")
    val orderKey: Int,

        @ColumnInfo(name = "title")
    val title: String,

        @ColumnInfo(name = "description")
    val description: String,

        @ColumnInfo(name = "pages_count")
    val noOfPages: Int,

        @PrimaryKey(autoGenerate = false)
        var topicId: String,

        @ColumnInfo(name = "is_locked")
        val isLocked: Boolean,

        @ColumnInfo(name = "is_completed")
        val isCompleted: Boolean,

        @ColumnInfo(name = "stars")
        val numOfStars: Float = 0f,

        @ColumnInfo(name = "is_last_topic")
        val isLastTopic: Boolean = false,

        @ColumnInfo(name = "next_topic_id")
        val nextTopicsId: String? = null
)