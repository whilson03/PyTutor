package com.olabode.wilson.pytutor.repository.learn

import com.olabode.wilson.pytutor.data.TutorialsDao
import com.olabode.wilson.pytutor.models.Tutorial
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 8/11/20.
 */
class LearnRepositoryImpl @Inject constructor(
        private val tutorialsDao: TutorialsDao
) : LearnRepository {

    override suspend fun updateProgress(newPercent: Int, order: Int) {
        withContext(Dispatchers.IO) {
            tutorialsDao.updateProgress(newPercent, order)
        }
    }

    override fun getAllBasicTutorials(): Flow<List<Tutorial>> {
        return tutorialsDao.getAllBasicTutorials().flowOn(Dispatchers.IO)
    }

    override fun getAllAdvancedTutorials(): Flow<List<Tutorial>> {
        return tutorialsDao.getAllAdvancedTutorials().flowOn(Dispatchers.IO)
    }

    override suspend fun unlockNextTutorial(currentTutorial: Tutorial) {
        withContext(Dispatchers.IO) {
            tutorialsDao.unlockedNextTutorial(currentTutorial.order + 1)
        }
    }
}