package com.olabode.wilson.pytutor.repository.main.algo

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.olabode.wilson.pytutor.data.algorithm.AlgorithmDao
import com.olabode.wilson.pytutor.mappers.algorithm.AlgorithmCacheMapper
import com.olabode.wilson.pytutor.mappers.algorithm.AlgorithmNetworkMapper
import com.olabode.wilson.pytutor.models.Algorithm
import com.olabode.wilson.pytutor.models.remote.algorithm.AlgorithmResponse
import com.olabode.wilson.pytutor.utils.DataState
import com.olabode.wilson.pytutor.utils.Messages
import com.olabode.wilson.pytutor.utils.RemoteDatabaseKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/29/20.
 */
class AlgorithmRepositoryImpl @Inject constructor(
        private val remoteDatabase: FirebaseFirestore,
        private val algorithmDao: AlgorithmDao,
        private val algorithmNetworkMapper: AlgorithmNetworkMapper,
        private val algorithmCacheMapper: AlgorithmCacheMapper
) : AlgorithmRepository {

    override fun fectchAllAlgorithms(): Flow<DataState<List<Algorithm>>> = flow {
        emit(DataState.Loading)

        val cachedAlgorithm = algorithmDao.getAlgorithms()

        if (cachedAlgorithm.isNullOrEmpty()) {
            val response = remoteDatabase
                    .collection(RemoteDatabaseKeys.NODE_ALGORITHMS)
                    .get().await()
            val algorithmResponse = response.documents

            if (!algorithmResponse.isNullOrEmpty()) {
                val result = algorithmResponse.map {
                    it?.toObject<AlgorithmResponse>()!!
                }

                val algorithms = algorithmNetworkMapper.mapFromEntityList(result)

                for (algorithm in algorithms) {
                    algorithmDao.insert(algorithmCacheMapper.mapToEntity(algorithm))
                }

                emit(DataState.Success(algorithms))
            } else {
                emit(DataState.Error(null, Messages.FAILED_TO_LOAD))
            }
        } else {
            val algorithms = algorithmCacheMapper.mapFromEntityList(cachedAlgorithm)
            emit(DataState.Success(algorithms))
        }

    }.catch {
        emit(DataState.Error(null, Messages.FAILED_TO_LOAD))
    }.flowOn(Dispatchers.IO)

}