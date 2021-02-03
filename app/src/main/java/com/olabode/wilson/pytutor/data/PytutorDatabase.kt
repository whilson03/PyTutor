package com.olabode.wilson.pytutor.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.olabode.wilson.pytutor.data.algorithm.AlgorithmDao
import com.olabode.wilson.pytutor.data.exercise.ExerciseDao
import com.olabode.wilson.pytutor.data.tutorial.LessonsDao
import com.olabode.wilson.pytutor.data.tutorial.TopicsDao
import com.olabode.wilson.pytutor.data.user.UserDao
import com.olabode.wilson.pytutor.models.cache.algorithm.AlgorithmEntity
import com.olabode.wilson.pytutor.models.cache.exercise.ExerciseEntity
import com.olabode.wilson.pytutor.models.cache.exercise.ExercisesTagConverter
import com.olabode.wilson.pytutor.models.cache.tutorial.LessonCacheEntity
import com.olabode.wilson.pytutor.models.cache.tutorial.TopicCacheEntity
import com.olabode.wilson.pytutor.models.cache.tutorial.converters.QuestionMapConverter
import com.olabode.wilson.pytutor.models.cache.tutorial.converters.TutorialMapConverter
import com.olabode.wilson.pytutor.models.cache.user.UserCacheEntity
import com.olabode.wilson.pytutor.models.cache.user.UserCompletedCoursesConverter

/**
 *   Created by OLABODE WILSON on 9/17/20.
 */

@TypeConverters(
        TutorialMapConverter::class,
        QuestionMapConverter::class,
        UserCompletedCoursesConverter::class,
        ExercisesTagConverter::class
)
@Database(
        entities = [
            TopicCacheEntity::class,
            LessonCacheEntity::class,
            UserCacheEntity::class,
            AlgorithmEntity::class,
            ExerciseEntity::class
        ],
        version = 1,
        exportSchema = false
)
abstract class PytutorDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicsDao

    abstract fun lessonDao(): LessonsDao

    abstract fun userDao(): UserDao

    abstract fun algorithmDao(): AlgorithmDao

    abstract fun exerciseDao(): ExerciseDao
}