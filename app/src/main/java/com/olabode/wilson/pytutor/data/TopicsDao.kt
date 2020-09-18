package com.olabode.wilson.pytutor.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.olabode.wilson.pytutor.models.tutorial.TopicResponse

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

@Dao
interface TopicsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserAll(topics: List<TopicResponse>)


}