package com.olabode.wilson.pytutor.repository.main.tutorial

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.olabode.wilson.pytutor.data.tutorial.LessonsDao
import com.olabode.wilson.pytutor.data.tutorial.TopicsDao
import com.olabode.wilson.pytutor.mappers.tutorial.LessonCacheMapper
import com.olabode.wilson.pytutor.mappers.tutorial.LessonNetworkMapper
import com.olabode.wilson.pytutor.mappers.tutorial.TopicCacheMapper
import com.olabode.wilson.pytutor.mappers.tutorial.TopicNetworkMapper
import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.TopicResponse
import com.olabode.wilson.pytutor.models.remote.user.RemoteUser
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.utils.Messages
import com.olabode.wilson.pytutor.utils.RemoteDatabaseKeys
import com.olabode.wilson.pytutor.utils.states.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */

@Singleton
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

    override fun retrieveTopicsFromRemote(userId: String): Flow<DataState<List<Topic>>> = flow {
        emit(DataState.Loading)
        val cachedTopics = topicsDao.getOneOrNull()

        if (cachedTopics < 1) {
            val topicsCollection = remoteDatabase
                    .collection(RemoteDatabaseKeys.NODE_TUTORIALS)
                    .get().await()

            val topicResponse = topicsCollection.documents

            val user = remoteDatabase
                    .collection(RemoteDatabaseKeys.NODE_USERS)
                    .document(userId).get().await().toObject<RemoteUser>()

            if (!topicResponse.isNullOrEmpty()) {
                val result = topicResponse.map {
                    it?.toObject<TopicResponse>()!!
                }
                val topics = topicNetworkMapper.mapFromEntityList(result)


                for (topic in topics) {
                    user?.let {
                        if (user.completedCourses.containsKey(topic.topicId)) {
                            topic.isCompleted = true
                            topic.isLocked = false
                            topic.numOfStars = user.completedCourses[topic.topicId] ?: 0f
                        }
                    }
                    topicsDao.insert(topicCacheMapper.mapToEntity(topic))
                }

                emit(DataState.Success(listOf<Topic>()))
            } else {
                emit(DataState.Error(null, Messages.FAILED_TO_LOAD_TOPICS))
            }
        } else {
            emit(DataState.Success(emptyList()))
        }
    }.catch { error ->
        Timber.e(error)
        emit(DataState.Error(null, Messages.FAILED_TO_LOAD_TOPICS))
    }.flowOn(Dispatchers.IO)

    override fun getAllCachedTopics(): Flow<List<Topic>> {
        return topicsDao.getTopics().distinctUntilChanged().map {
            topicCacheMapper.mapFromEntityList(it)
        }.catch { e ->
            Timber.e(e)
        }.flowOn(Dispatchers.IO)
    }

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
                }

                emit(DataState.Success(lessons))
            } else {
                emit(DataState.Error(null, Messages.FAILED_TO_LOAD_LESSONS))
            }
        } else {
            val lessons = lessonsCacheMapper.mapFromEntityList(cachedLessons)
            emit(DataState.Success(lessons))
        }
    }.catch { e ->
        Timber.e(e)
        emit(DataState.Error(null, Messages.FAILED_TO_LOAD_LESSONS))
    }.flowOn(Dispatchers.IO)

    override suspend fun clearTopics() {
        withContext(Dispatchers.IO) {
            topicsDao.clearTopics()
            lessonsDao.clearLessons()
        }
    }

    override fun getNextTopic(topicId: String): Flow<DataState<Topic>> = flow {
        emit(DataState.Loading)
        val nextTopic = topicsDao.getTopic(topicId)

        if (nextTopic != null) {
            emit(DataState.Success(topicCacheMapper.mapFromEntity(nextTopic)))
        } else {
            emit(DataState.Error(null, Messages.GENERIC_FAILURE))
        }
    }.catch {
        emit(DataState.Error(null, Messages.GENERIC_FAILURE))
    }.flowOn(Dispatchers.IO)
}