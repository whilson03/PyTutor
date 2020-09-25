package com.olabode.wilson.pytutor.repository.auth

import com.google.firebase.auth.FirebaseUser
import com.olabode.wilson.pytutor.utils.AuthResult
import com.olabode.wilson.pytutor.utils.DataState
import kotlinx.coroutines.flow.Flow

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
interface AuthRepository {

    fun loginUser(
            email: String,
            password: String
    ): Flow<AuthResult<String>>

    fun registerNewUser(
            fullName: String,
            email: String,
            password: String,
            confirmPassword: String
    ): Flow<AuthResult<String>>

    fun logOut()

    suspend fun sendEmailVerificationLink(firebaseUser: FirebaseUser)

    fun currentUserId(): String

    fun sendPasswordResetLink(email: String): Flow<DataState<String>>

    fun sendEmailVerificationLink(email: String, password: String): Flow<DataState<String>>


}