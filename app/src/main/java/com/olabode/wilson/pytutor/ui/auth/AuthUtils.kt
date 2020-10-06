package com.olabode.wilson.pytutor.ui.auth

/**
 *   Created by OLABODE WILSON on 10/2/20.
 */
object AuthUtils {

    fun validateLoginDetails(
        email: String,
        password: String
    ): Boolean {
        return true
    }

    fun validateRegistrationDetails(
        fullName: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        return true
    }
}

sealed class Val