package com.olabode.wilson.pytutor.data.tutorial

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olabode.wilson.pytutor.models.cache.tutorial.TopicCacheEntity
import kotlinx.coroutines.flow.Flow

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

@Dao
interface TopicsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(topics: TopicCacheEntity)

    @Query("SELECT * FROM topics_table")
    fun getTopics(): Flow<List<TopicCacheEntity>>

    @Query("SELECT * FROM topics_table LIMIT 1")
    fun getOneOrNull(): Int

    @Query("DELETE FROM topics_table")
    suspend fun clearTopics()

    @Query("UPDATE topics_table SET  is_completed = 1 , stars=:stars WHERE topicId =:topicId")
    suspend fun updateCompletedCourse(topicId: String, stars: Float)

    @Query("UPDATE topics_table SET is_locked = 0 WHERE order_key =:orderKey")
    suspend fun unlockNextTopic(orderKey: Int)
}