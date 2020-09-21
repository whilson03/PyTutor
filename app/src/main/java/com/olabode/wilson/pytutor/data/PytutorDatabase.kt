package com.olabode.wilson.pytutor.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.olabode.wilson.pytutor.data.tutorial.LessonsDao
import com.olabode.wilson.pytutor.data.tutorial.TopicsDao
import com.olabode.wilson.pytutor.data.user.UserDao
import com.olabode.wilson.pytutor.models.cache.tutorial.LessonCacheEntity
import com.olabode.wilson.pytutor.models.cache.tutorial.TopicCacheEntity
import com.olabode.wilson.pytutor.models.cache.tutorial.converters.QuestionMapConverter
import com.olabode.wilson.pytutor.models.cache.tutorial.converters.TutorialMapConverter
import com.olabode.wilson.pytutor.models.cache.user.UserBadgeTypeConverter
import com.olabode.wilson.pytutor.models.cache.user.UserCacheEntity

/**
 *   Created by OLABODE WILSON on 9/17/20.
 */

@TypeConverters(
        TutorialMapConverter::class,
        QuestionMapConverter::class,
        UserBadgeTypeConverter::class
)
@Database(
        entities = [
            TopicCacheEntity::class,
            LessonCacheEntity::class,
            UserCacheEntity::class
        ],
        version = 1,
        exportSchema = false
)
abstract class PytutorDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicsDao

    abstract fun lessonDao(): LessonsDao

    abstract fun userDao(): UserDao
}