package com.olabode.wilson.pytutor.data.tutorial

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olabode.wilson.pytutor.models.cache.tutorial.TopicCacheEntity

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

@Dao
interface TopicsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(topics: TopicCacheEntity)

    @Query("SELECT * FROM topics_table")
    suspend fun getTopics(): List<TopicCacheEntity>

    @Query("DELETE FROM topics_table")
    suspend fun clearTopics()

}