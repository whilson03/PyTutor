package com.olabode.wilson.pytutor.models.cache.algorithm

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 *   Created by OLABODE WILSON on 9/27/20.
 */
@Entity(tableName = "algorithm_table")
data class AlgorithmEntity(
        @ColumnInfo(name = "id")
        val id: String,
        @ColumnInfo(name = "title")
        val title: String,
        @ColumnInfo(name = "description")
        val description: String,
        @ColumnInfo(name = "body")
        val body: String
)