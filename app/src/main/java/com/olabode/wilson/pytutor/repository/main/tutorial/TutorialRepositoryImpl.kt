package com.olabode.wilson.pytutor.repository.main.tutorial

import com.google.firebase.FirebaseException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import com.olabode.wilson.pytutor.models.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.tutorial.TopicResponse
import com.olabode.wilson.pytutor.utils.DataState
import com.olabode.wilson.pytutor.utils.Messages
import com.olabode.wilson.pytutor.utils.RemoteDatabaseKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
@ExperimentalCoroutinesApi
@Singleton
class TutorialRepositoryImpl @Inject constructor(private val remoteDatabase: FirebaseFirestore)
    : TutorialRepository {

    override fun getAllTopics(): Flow<DataState<List<TopicResponse>>> = callbackFlow {
        val topicsCollection = remoteDatabase
                .collection(RemoteDatabaseKeys.NODE_TUTORIALS)
                .document(RemoteDatabaseKeys.DOC_TOPICS)
                .collection(RemoteDatabaseKeys.ALL_TOPICS)


        val listener = topicsCollection.addSnapshotListener { snapshot, exception ->
            if (snapshot != null) {
                offer(DataState.Success(snapshot.toObjects<TopicResponse>()))
            }
            // If exception occurs, cancel this scope with exception message.
            exception?.let {
                offer(DataState.Error(FirebaseException(Messages.EXCEPTION_MESSAGE)))
                cancel()
            }
        }
        awaitClose {
            listener.remove()
            cancel()
        }
    }.flowOn(Dispatchers.IO)

    override fun getLessonsForTopic(topicId: String): Flow<DataState<List<LessonResponse>>> = flow {
        emit(DataState.Loading)

        val response = remoteDatabase
                .collection(RemoteDatabaseKeys.NODE_TUTORIALS)
                .document(RemoteDatabaseKeys.DOC_LESSONS)
                .collection(topicId)
                .get().await()

        if (response.isEmpty) {
            emit(DataState.Failed(Messages.GENERIC_FAILURE))
        } else {
            emit(DataState.Success(response.toObjects<LessonResponse>()))
        }
    }.catch { e ->
        Timber.e(e)
        emit(DataState.Failed(Messages.GENERIC_FAILURE))
    }.flowOn(Dispatchers.IO)
}