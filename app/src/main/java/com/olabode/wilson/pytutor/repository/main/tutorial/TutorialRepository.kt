package com.olabode.wilson.pytutor.repository.main.tutorial

import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.utils.states.DataState
import kotlinx.coroutines.flow.Flow

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
interface TutorialRepository {

    fun retrieveTopicsFromRemote(userId: String): Flow<DataState<List<Topic>>>

    fun getAllCachedTopics(): Flow<List<Topic>>

    fun getLessonsForTopic(topicId: String): Flow<DataState<List<Lesson>>>

    suspend fun clearTopics()

    fun getNextTopic(orderKey: Int): Flow<DataState<Topic>>
}