package com.olabode.wilson.pytutor.repository.learn

import com.olabode.wilson.pytutor.models.Tutorial
import kotlinx.coroutines.flow.Flow


/**
 *   Created by OLABODE WILSON on 8/11/20.
 */
interface LearnRepository {

    suspend fun updateProgress(newPercent: Int, order: Int)

    fun getAllBasicTutorials(): Flow<List<Tutorial>>

    fun getAllAdvancedTutorials(): Flow<List<Tutorial>>

    suspend fun unlockNextTutorial(currentTutorial: Tutorial)
}