package com.olabode.wilson.pytutor.repository.main.tutorial

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.olabode.wilson.pytutor.data.LessonsDao
import com.olabode.wilson.pytutor.data.TopicsDao
import com.olabode.wilson.pytutor.mappers.tutorial.LessonCacheMapper
import com.olabode.wilson.pytutor.mappers.tutorial.LessonNetworkMapper
import com.olabode.wilson.pytutor.mappers.tutorial.TopicCacheMapper
import com.olabode.wilson.pytutor.mappers.tutorial.TopicNetworkMapper
import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.TopicResponse
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.utils.DataState
import com.olabode.wilson.pytutor.utils.Messages
import com.olabode.wilson.pytutor.utils.RemoteDatabaseKeys
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */

@Module
@InstallIn(ActivityRetainedComponent::class)
@ExperimentalCoroutinesApi
class TutorialRepositoryImpl @Inject constructor(
        private val remoteDatabase: FirebaseFirestore,
        private val topicNetworkMapper: TopicNetworkMapper,
        private val topicCacheMapper: TopicCacheMapper,
        private val lessonNetworkMapper: LessonNetworkMapper,
        private val lessonsCacheMapper: LessonCacheMapper,
        private val topicsDao: TopicsDao,
        private val lessonsDao: LessonsDao
) : TutorialRepository {

    override fun getAllTopics(): Flow<DataState<List<Topic>>> = flow {
        val cachedTopics = topicsDao.getTopics()
        emit(DataState.Loading)

        if (cachedTopics.isNullOrEmpty()) {
            val topicsCollection = remoteDatabase
                    .collection(RemoteDatabaseKeys.NODE_TUTORIALS)
                    .get().await()

            val topicResponse = topicsCollection.documents

            if (!topicResponse.isNullOrEmpty()) {
                val result = topicResponse.map {
                    it?.toObject<TopicResponse>()!!
                }
                val topics = topicNetworkMapper.mapFromEntityList(result)

                for (topic in topics) {
                    topicsDao.insert(topicCacheMapper.mapToEntity(topic))
                    Timber.d("INSERTING ${topic.topicId}")
                }

                emit(DataState.Success(topics))

            } else {
                emit(DataState.Error(null, "NO TOPICS AVAILABLE"))
            }

        } else {
            val topics = topicCacheMapper.mapFromEntityList(cachedTopics)
            emit(DataState.Success(topics))
        }
    }.catch { error ->
        Timber.e(error)
        emit(DataState.Error(null, "ERROR LOADING TOPICS"))
    }.flowOn(Dispatchers.IO)

    override fun getLessonsForTopic(topicId: String): Flow<DataState<List<Lesson>>> = flow {
        emit(DataState.Loading)

        val cachedLessons = lessonsDao.getLessonById(topicId)

        if (cachedLessons.isNullOrEmpty()) {
            val response = remoteDatabase
                    .collection(RemoteDatabaseKeys.NODE_TUTORIALS)
                    .document(topicId)
                    .collection(RemoteDatabaseKeys.NODE_LESSONS)
                    .get().await()
            val lessonResponse = response.documents

            if (!lessonResponse.isNullOrEmpty()) {
                val result = lessonResponse.map {
                    it?.toObject<LessonResponse>()!!
                }

                val lessons = lessonNetworkMapper.mapFromEntityList(result)

                for (lesson in lessons) {
                    lessonsDao.insert(lessonsCacheMapper.mapToEntity(lesson))
                    Timber.d("INSERTING ${lesson.topicId}")
                }

                emit(DataState.Success(lessons))
            } else {
                emit(DataState.Error(null, "NO LESSONS AVAILABLE"))
            }
        } else {
            val lessons = lessonsCacheMapper.mapFromEntityList(cachedLessons)
            emit(DataState.Success(lessons))
        }
    }.catch { e ->
        Timber.e(e)
        emit(DataState.Error(null, Messages.GENERIC_FAILURE))
    }.flowOn(Dispatchers.IO)
}