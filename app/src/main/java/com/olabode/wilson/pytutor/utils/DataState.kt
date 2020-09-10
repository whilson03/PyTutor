package com.olabode.wilson.pytutor.utils

import com.google.firebase.FirebaseException

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
sealed class DataState<out R> {

    data class Success<out T>(val data: T) : DataState<T>()
    data class Failed<out T>(val message: String) : DataState<T>()
    data class Error(val exception: FirebaseException) : DataState<Nothing>()
    object Loading : DataState<Nothing>()


    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
            is Failed -> "Failed"
        }
    }
}