package com.olabode.wilson.pytutor.repository

import com.olabode.wilson.pytutor.utils.DataState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

abstract class NetworkBoundResource<NetworkObj, CacheObj, ResultType> constructor(
        private val dispatcher: CoroutineDispatcher,
        private val apiCall: suspend () -> NetworkObj?,
        private val cacheCall: suspend () -> CacheObj?
) {

    val result: Flow<DataState<ResultType>> = flow {
        emit(DataState.Loading)

        val cacheResult = returnCache()
        when (cacheResult) {
            is DataState.Success -> {
                if (shouldFetch(cacheResult.data)) {
                    Timber.d("CALLING NETWORK")
                    when (val apiResult = safeApiCall(dispatcher) { apiCall.invoke() }) {
                        is ApiResult.Success -> {
                            if (apiResult.value == null) {
                                Timber.e("ERROR RETRIEVING FROM NETWORK")
                                emit(DataState.Error(null, "FAILED TO RETRIEVE"))
                            } else {
                                updateCache(apiResult.value)
                                emit(returnCache())
                            }
                        }

                        is ApiResult.GenericError -> {
                            emit(DataState.Error(null, "FAILED TO RETRIEVE API RESULT"))
                        }
                    }
                } else {
                    Timber.d("EMITTING CACHE")
                    emit(returnCache())
                }
            }
            is DataState.Error -> {
                emit(DataState.Error(null, "FAILED TO RETRIEVE CACHE"))
            }
        }

    }


    private suspend fun returnCache(): DataState<ResultType> {

        val cacheResult = safeCacheCall(dispatcher) { cacheCall.invoke() }

        return object : CacheResponseHandler<ResultType, CacheObj>(
                response = cacheResult

        ) {
            override suspend fun handleSuccess(resultObj: CacheObj): DataState<ResultType> {
                return handleCacheSuccess(resultObj)
            }
        }.getResult()

    }


    abstract fun handleCacheSuccess(resultObj: CacheObj): DataState<ResultType>

    abstract suspend fun updateCache(networkObject: NetworkObj)

    abstract fun shouldFetch(data: ResultType?): Boolean

}