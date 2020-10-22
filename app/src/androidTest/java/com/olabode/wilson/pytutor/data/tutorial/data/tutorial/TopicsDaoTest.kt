package com.olabode.wilson.pytutor.data.tutorial.data.tutorial

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.olabode.wilson.pytutor.data.PytutorDatabase
import com.olabode.wilson.pytutor.data.tutorial.TopicsDao
import com.olabode.wilson.pytutor.models.cache.tutorial.TopicCacheEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
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
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            PytutorDatabase::class.java
        ).setTransactionExecutor(testDispatcher.asExecutor())
            .setQueryExecutor(testDispatcher.asExecutor()).build()
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
    fun insertTopicCacheEntity() = testScope.runBlockingTest {
        val topic = TopicCacheEntity(1, "hello", "desc", 5,
            "ry", isLocked = false, isCompleted = false, numOfStars = 0f

        )
        dao.insert(topic)

        val topics = async {
            dao.getTopics().take(1).toList().flatten()
        }

        assertThat(topics.await()).containsExactly(topic)

    }
}