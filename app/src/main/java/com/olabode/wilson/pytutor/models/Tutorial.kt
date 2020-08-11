package com.olabode.wilson.pytutor.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   Created by OLABODE WILSON on 8/11/20.
 */

@Entity(tableName = "Tutorials")
data class Tutorial(
        @PrimaryKey(autoGenerate = true)
        val id: Int,

        @ColumnInfo(name = "topic")
        val topic: String,

        @ColumnInfo(name = "description")
        val shortDescription: String,

        @ColumnInfo(name = "is_locked")
        val isLocked: Boolean = true,

        @ColumnInfo(name = "percentage")
        val completionPercent: Int = 0,

        @ColumnInfo(name = "learn_order")
        val order: Int,

        @ColumnInfo(name = "tutorial_type")
        val isBasic: Boolean

)