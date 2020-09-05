package com.olabode.wilson.pytutor.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.olabode.wilson.pytutor.models.User
import com.olabode.wilson.pytutor.utils.AuthResult
import com.olabode.wilson.pytutor.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
class UserRepositoryImpl @Inject constructor(
        private val auth: FirebaseAuth,
        private val remoteDatabase: FirebaseFirestore
) : UserRepository {
    override fun getUserDetail(): Flow<DataState<User>> {
        TODO("Not yet implemented")
    }

    override fun loginUser(email: String, password: String): Flow<AuthResult<String>> {
        TODO("Not yet implemented")
    }

    override fun registerNewUser(fullName: String, email: String, password: String, confirmPassword: String): Flow<AuthResult<String>> {
        TODO("Not yet implemented")
    }

    override fun logOut(): Flow<AuthResult<String>> {
        TODO("Not yet implemented")
    }

    override fun sendEmailVerificationLink(firebaseUser: FirebaseUser) {
        TODO("Not yet implemented")
    }

}