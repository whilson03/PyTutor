package com.olabode.wilson.pytutor.repository.main.exercise

import com.google.firebase.firestore.FirebaseFirestore
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

    override fun fetchExercises(): Flow<DataState<List<Exercise>>> = flow {
        emit(DataState.Loading)

        val cachedExercise = exerciseDao.retrieveExercises()

        if (cachedExercise.isNullOrEmpty()) {
            val response = remoteDatabase
                .collection(RemoteDatabaseKeys.NODE_EXERCISES)
                .get().await()
            val exerciseResponse = response.documents

            if (!exerciseResponse.isNullOrEmpty()) {
                val result = exerciseResponse.map {
                    it?.toObject<ExerciseResponse>()!!
                }

                val exercises = exerciseNetworkMapper.mapFromEntityList(result)

                for (exercise in exercises) {
                    exerciseDao.insert(exerciseCacheMapper.mapToEntity(exercise))
                }

                emit(DataState.Success(exercises))
            }
            else {
                emit(DataState.Error(null, Messages.FAILED_TO_LOAD))
            }
        }
        else {
            val exercises = exerciseCacheMapper.mapFromEntityList(cachedExercise)
            emit(DataState.Success(exercises))
        }
    }.catch { e ->
        Timber.e(e)
        emit(DataState.Error(null, Messages.FAILED_TO_LOAD))
    }.flowOn(Dispatchers.IO)
}