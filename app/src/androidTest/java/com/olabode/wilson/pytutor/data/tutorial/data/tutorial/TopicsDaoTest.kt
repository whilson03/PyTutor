package com.olabode.wilson.pytutor.data.tutorial.data.tutorial

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.olabode.wilson.pytutor.data.PytutorDatabase
import com.olabode.wilson.pytutor.data.tutorial.TopicsDao
import com.olabode.wilson.pytutor.models.cache.tutorial.TopicCacheEntity
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.time.ExperimentalTime

/**
 *   Created by OLABODE WILSON on 10/4/20.
 */
@ExperimentalCoroutinesApi

@RunWith(AndroidJUnit4::class)
class TopicsDaoTest {

    private lateinit var database: PytutorDatabase
    private lateinit var dao: TopicsDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            PytutorDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.topicDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @InternalCoroutinesApi
    @ExperimentalCoroutinesApi
    @ExperimentalTime
    @Test
    fun insertTopicCacheEntity() = runBlockingTest {
        val topic = TopicCacheEntity(1, "hello", "desc", 5,
            "ry", isLocked = false, isCompleted = false, numOfStars = 0f

        )
        dao.insert(topic)

        dao.getTopics().test {
            assertEquals(listOf(topic), expectItem())
            expectComplete()
        }

    }
}