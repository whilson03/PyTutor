package com.olabode.wilson.pytutor.repository

import com.google.firebase.auth.FirebaseUser
import com.olabode.wilson.pytutor.models.User
import com.olabode.wilson.pytutor.utils.AuthResult
import com.olabode.wilson.pytutor.utils.DataState
import kotlinx.coroutines.flow.Flow

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
interface UserRepository {

    fun getUserDetail(): Flow<DataState<User>>

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

    fun logOut(): Flow<AuthResult<String>>

    fun sendEmailVerificationLink(firebaseUser: FirebaseUser)

}