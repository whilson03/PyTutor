package com.olabode.wilson.pytutor.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olabode.wilson.pytutor.models.Tutorial
import kotlinx.coroutines.flow.Flow

/**
 *   Created by OLABODE WILSON on 8/11/20.
 */

@Dao
interface TutorialsDao {

    @Query("UPDATE tutorials SET percentage =:newPercent WHERE learn_order =:order ")
    suspend fun updateProgress(newPercent: Int, order: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Tutorial>)

    @Query("SELECT * FROM Tutorials WHERE tutorial_type = 1")
    fun getAllBasicTutorials(): Flow<List<Tutorial>>

    @Query("SELECT * FROM Tutorials WHERE tutorial_type = 0")
    fun getAllAdvancedTutorials(): Flow<List<Tutorial>>

    @Query("UPDATE tutorials SET is_locked = 0 WHERE learn_order =:order ")
    suspend fun unlockedNextTutorial(order: Int)

}