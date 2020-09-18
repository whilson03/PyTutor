package com.olabode.wilson.pytutor.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

sealed class CacheResult<out T> {

    data class Success<out T>(val value: T) : CacheResult<T>()

    data class GenericError(
            val errorMessage: String? = null
    ) : CacheResult<Nothing>()
}


sealed class ApiResult<out T> {
    data class Success<out T>(val value: T) : ApiResult<T>()

    data class GenericError(
            val errorMessage: String? = null
    ) : ApiResult<Nothing>()

}


const val CACHE_TIMEOUT = 2000L
const val CACHE_ERROR_TIMEOUT = "Cache timeout"
const val UNKNOWN_ERROR = "Unknown error"
const val NETWORK_TIMEOUT = 6000L


suspend fun <T> safeCacheCall(
        dispatcher: CoroutineDispatcher,
        cacheCall: suspend () -> T?
): CacheResult<T?> {
    return withContext(dispatcher) {
        try {
            // throws TimeoutCancellationException
            withTimeout(CACHE_TIMEOUT) {
                CacheResult.Success(cacheCall.invoke())
            }
        } catch (throwable: Throwable) {
            when (throwable) {
                is TimeoutCancellationException -> {
                    CacheResult.GenericError(CACHE_ERROR_TIMEOUT)
                }
                else -> {
                    CacheResult.GenericError(UNKNOWN_ERROR)
                }
            }
        }
    }
}


suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> T?
): ApiResult<T?> {
    return withContext(dispatcher) {
        try {
            // throws TimeoutCancellationException
            withTimeout(NETWORK_TIMEOUT) {
                ApiResult.Success(apiCall.invoke())
            }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            ApiResult.GenericError(throwable.message)

        }
    }
}

