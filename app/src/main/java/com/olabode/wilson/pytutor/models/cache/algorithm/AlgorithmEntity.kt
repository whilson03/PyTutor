package com.olabode.wilson.pytutor.models.cache.algorithm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   Created by OLABODE WILSON on 9/27/20.
 */
@Entity(tableName = "algorithm_table")
data class AlgorithmEntity(
        @ColumnInfo(name = "id")
        @PrimaryKey
        val id: String,
        @ColumnInfo(name = "title")
        val title: String,
        @ColumnInfo(name = "description")
        val description: String,
        @ColumnInfo(name = "body")
        val body: String
)