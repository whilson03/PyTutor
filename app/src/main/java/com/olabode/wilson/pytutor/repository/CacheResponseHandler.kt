package com.olabode.wilson.pytutor.repository

import com.olabode.wilson.pytutor.utils.DataState

abstract class CacheResponseHandler<ResultType, Data>(
        private val response: CacheResult<Data?>
) {
    suspend fun getResult(): DataState<ResultType> {

        return when (response) {

            is CacheResult.GenericError -> {
                DataState.Error(null, "FAILED IN CACHED HANDLER")
            }

            is CacheResult.Success -> {
                if (response.value == null) {
                    DataState.Error(null, "FAILED IN CACHED HANDLER")
                } else {
                    handleSuccess(resultObj = response.value)
                }
            }

        }
    }

    abstract suspend fun handleSuccess(resultObj: Data): DataState<ResultType>

}