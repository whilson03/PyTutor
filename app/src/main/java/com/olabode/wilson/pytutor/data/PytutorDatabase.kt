package com.olabode.wilson.pytutor.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.olabode.wilson.pytutor.models.cache.tutorial.TopicCacheEntity

/**
 *   Created by OLABODE WILSON on 9/17/20.
 */

@Database(
        entities = [TopicCacheEntity::class],
        version = 1,
        exportSchema = false
)
abstract class PytutorDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicsDao
}