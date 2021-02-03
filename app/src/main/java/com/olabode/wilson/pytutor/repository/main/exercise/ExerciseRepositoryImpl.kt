package com.olabode.wilson.pytutor.repository.main.exercise

import androidx.room.withTransaction
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.olabode.wilson.pytutor.data.PytutorDatabase
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
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */

class ExerciseRepositoryImpl @Inject constructor(
        private val remoteDatabase: FirebaseFirestore,
        private val exerciseDao: ExerciseDao,
        private val exerciseNetworkMapper: ExerciseNetworkMapper,
        private val exerciseCacheMapper: ExerciseCacheMapper,
        private val localDatabase: PytutorDatabase
) : ExerciseRepository {


    override fun fetchExercises(): Flow<DataState<List<Exercise>>> = flow {
        emit(DataState.Loading)

        val cachedExercise = exerciseDao.retrieveExercises()

        if (cachedExercise.isNullOrEmpty()) {
            val remoteExercises = remoteDatabase
                    .collection(RemoteDatabaseKeys.NODE_EXERCISES)
                    .get().await().documents

            if (!remoteExercises.isNullOrEmpty()) {
                val listOfNetworkExercises = remoteExercises.map { it?.toObject<ExerciseResponse>()!! }
                val exercisesList = exerciseNetworkMapper.mapFromEntityList(listOfNetworkExercises)
                val cacheList = exerciseCacheMapper.mapToEntityList(exercisesList)

                localDatabase.withTransaction {
                    exerciseDao.insertAll(cacheList)
                }
                emit(DataState.Success(exercisesList.sortedBy { it.difficulty }))
            } else {
                emit(DataState.Error(null, Messages.FAILED_TO_LOAD_EXERCISES))
            }
        } else {
            emit(DataState.Success(exerciseCacheMapper.mapFromEntityList(cachedExercise)))
        }

    }.catch { e ->
        Timber.e(e)
        emit(DataState.Error(null, Messages.FAILED_TO_LOAD_EXERCISES))
    }.flowOn(Dispatchers.IO)

    override suspend fun clearExercises() {
        withContext(Dispatchers.IO) {
            exerciseDao.clear()
        }
    }

    override suspend fun uploadExercise(exercise: Exercise): Flow<DataState<String>> = flow {
        emit(DataState.Loading)

        val ref = remoteDatabase.collection(RemoteDatabaseKeys.NODE_EXERCISES)
        val pushId = ref.document().id
        exercise.id = pushId
        ref.document(pushId).set(exerciseNetworkMapper.mapToEntity(exercise)).await()

        emit(DataState.Success(Messages.UPLOAD_SUCCESS))
    }.catch {
        emit(DataState.Error(null, Messages.GENERIC_FAILURE))
    }.flowOn(Dispatchers.IO)
}