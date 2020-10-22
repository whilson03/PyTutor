package com.olabode.wilson.pytutor.repository.main.exercise

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.toObject
import com.olabode.wilson.pytutor.data.exercise.ExerciseDao
import com.olabode.wilson.pytutor.mappers.exercise.ExerciseCacheMapper
import com.olabode.wilson.pytutor.mappers.exercise.ExerciseNetworkMapper
import com.olabode.wilson.pytutor.models.Exercise
import com.olabode.wilson.pytutor.models.remote.exercise.ExerciseResponse
import com.olabode.wilson.pytutor.utils.Messages
import com.olabode.wilson.pytutor.utils.RemoteDatabaseKeys
import com.olabode.wilson.pytutor.utils.states.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */

class ExerciseRepositoryImpl @Inject constructor(
        private val remoteDatabase: FirebaseFirestore,
        private val exerciseDao: ExerciseDao,
        private val exerciseNetworkMapper: ExerciseNetworkMapper,
        private val exerciseCacheMapper: ExerciseCacheMapper
) : ExerciseRepository {

    val first = remoteDatabase.collection(RemoteDatabaseKeys.NODE_EXERCISES).limit(25)
    var next: Query? = null


    override fun fetchExercises(): Flow<DataState<List<Exercise>>> = flow {
        emit(DataState.Loading)
        val nextQuery = next
        if (nextQuery != null) {
            val snapshot = nextQuery.get().await()
            val lastVisible = snapshot.documents[snapshot.size() - 1]
            next = remoteDatabase.collection(RemoteDatabaseKeys.NODE_EXERCISES)
                    .startAfter(lastVisible)
                    .limit(25)

            val result = snapshot.documents.map {
                it.toObject<ExerciseResponse>()!!
            }
            val exercises = exerciseNetworkMapper.mapFromEntityList(result)
            emit(DataState.Success(exercises))
        } else {
            val firstSnapshot = first.get().await()
            val lastVisible = firstSnapshot.documents[firstSnapshot.size() - 1]
            next = remoteDatabase.collection(RemoteDatabaseKeys.NODE_EXERCISES)
                    .startAfter(lastVisible)
                    .limit(25)
            val result = firstSnapshot.documents.map {
                it.toObject<ExerciseResponse>()!!
            }
            val exercises = exerciseNetworkMapper.mapFromEntityList(result)
            emit(DataState.Success(exercises))
        }
    }.catch { e ->
        Timber.e(e)
        emit(DataState.Error(null, Messages.FAILED_TO_LOAD))
    }.flowOn(Dispatchers.IO)

    override fun refresh() {
        next = null

    }
}