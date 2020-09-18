package com.olabode.wilson.pytutor.repository.main.tutorial

import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.utils.DataState
import kotlinx.coroutines.flow.Flow

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
interface TutorialRepository {

    fun getAllTopics(): Flow<DataState<List<Topic>>>

    fun getLessonsForTopic(topicId: String): Flow<DataState<List<LessonResponse>>>

}