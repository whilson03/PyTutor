package com.olabode.wilson.pytutor.models.cache.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.olabode.wilson.pytutor.models.Badge

/**
 *   Created by OLABODE WILSON on 9/20/20.
 */

@Entity(tableName = "user_table")
data class UserCacheEntity(
        @ColumnInfo(name = "full_name")
        val fullName: String,
        @ColumnInfo(name = "email")
        val email: String,
        @ColumnInfo(name = "level")
        val level: Int = 0,
        @ColumnInfo(name = "xp")
        val experiencePoint: Int = 0,
        @ColumnInfo(name = "image_url")
        val imageUrl: String,
        @ColumnInfo(name = "badges")
        val badges: List<Badge>,
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "user_id")
        val userId: String,
        val completedCourses: Map<String, Float>
)