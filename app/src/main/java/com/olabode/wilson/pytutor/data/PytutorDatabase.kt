package com.olabode.wilson.pytutor.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.olabode.wilson.pytutor.models.cache.tutorial.LessonCacheEntity
import com.olabode.wilson.pytutor.models.cache.tutorial.TopicCacheEntity
import com.olabode.wilson.pytutor.models.cache.tutorial.converters.QuestionMapConverter
import com.olabode.wilson.pytutor.models.cache.tutorial.converters.TutorialMapConverter

/**
 *   Created by OLABODE WILSON on 9/17/20.
 */

@TypeConverters(TutorialMapConverter::class, QuestionMapConverter::class)
@Database(
        entities = [TopicCacheEntity::class, LessonCacheEntity::class],
        version = 4,
        exportSchema = false
)
abstract class PytutorDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicsDao

    abstract fun lessonDao(): LessonsDao
}