package com.olabode.wilson.pytutor.repository.main.tutorial

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.olabode.wilson.pytutor.data.TopicsDao
import com.olabode.wilson.pytutor.mappers.tutorial.TopicCacheMapper
import com.olabode.wilson.pytutor.mappers.tutorial.TopicNetworkMapper
import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.TopicResponse
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
        private val networkMapper: TopicNetworkMapper,
        private val cacheMapper: TopicCacheMapper,
        private val topicsDao: TopicsDao
) : TutorialRepository {

    override fun getAllTopics(): Flow<DataState<List<Topic>>> = flow {
        val cachedTopics = topicsDao.getTopics()
        emit(DataState.Loading)

        if (cachedTopics.isEmpty()) {
            val topicsCollection = remoteDatabase
                    .collection(RemoteDatabaseKeys.NODE_TUTORIALS)
                    .document(RemoteDatabaseKeys.DOC_TOPICS)
                    .collection(RemoteDatabaseKeys.ALL_TOPICS)
                    .get().await()

            val topicResponse = topicsCollection.documents

            if (!topicResponse.isNullOrEmpty()) {
                val result = topicResponse.map {
                    it?.toObject<TopicResponse>()!!
                }
                val topics = networkMapper.mapFromEntityList(result)

                for (topic in topics) {
                    topicsDao.insert(cacheMapper.mapToEntity(topic))
                    Timber.d("INSERTING ${topic.topicId}")
                }

                emit(DataState.Success(topics))

            } else {
                emit(DataState.Error(null, "NO TOPICS AVAILABLE"))
            }

        } else {
            val topics = cacheMapper.mapFromEntityList(cachedTopics)
            emit(DataState.Success(topics))
        }
    }.catch { error ->
        Timber.e(error)
        emit(DataState.Error(null, "ERROR LOADING TOPICS"))
    }.flowOn(Dispatchers.IO)

    override fun getLessonsForTopic(topicId: String): Flow<DataState<List<LessonResponse>>> = flow {
        emit(DataState.Loading)

        val response = remoteDatabase
                .collection(RemoteDatabaseKeys.NODE_TUTORIALS)
                .document(RemoteDatabaseKeys.DOC_LESSONS)
                .collection(topicId)
                .get().await()

        if (response.isEmpty) {
            emit(DataState.Error(null, Messages.GENERIC_FAILURE))
        } else {
            emit(DataState.Success(response.toObjects<LessonResponse>()))
        }
    }.catch { e ->
        Timber.e(e)
        emit(DataState.Error(null, Messages.GENERIC_FAILURE))
    }.flowOn(Dispatchers.IO)
}