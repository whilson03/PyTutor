package com.olabode.wilson.pytutor.data.tutorial

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olabode.wilson.pytutor.models.cache.tutorial.LessonCacheEntity

/**
 *   Created by OLABODE WILSON on 9/17/20.
 */

@Dao
interface LessonsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lesson: LessonCacheEntity)

    @Query("SELECT * FROM lesson_table WHERE topic_id =:topicId ORDER BY page ASC ")
    suspend fun getLessonById(topicId: String): List<LessonCacheEntity>

    @Query("DELETE FROM lesson_table")
    suspend fun clearLessons()
}