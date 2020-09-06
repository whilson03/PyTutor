package com.olabode.wilson.pytutor.utils

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
sealed class AuthResult<out R> {
    data class Success<out T>(val data: T) : AuthResult<T>()
    data class Failed<out T>(val data: T) : AuthResult<T>()
    object Loading : AuthResult<Nothing>()
    object UnAuthenticated : AuthResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            Loading -> "Loading"
            UnAuthenticated -> "UnAuthenticated"
            is Failed -> "Failed"
        }
    }
}