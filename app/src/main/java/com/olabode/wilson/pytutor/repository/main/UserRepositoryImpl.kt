package com.olabode.wilson.pytutor.repository.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.olabode.wilson.pytutor.utils.AuthResult
import com.olabode.wilson.pytutor.utils.FirebaseUserLiveData
import com.olabode.wilson.pytutor.utils.Messages
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
@Singleton
class UserRepositoryImpl @Inject constructor(
        private val auth: FirebaseAuth,
        private val remoteDatabase: FirebaseFirestore
) : UserRepository {
    override fun checkLoginStatus(): LiveData<AuthResult<String>> {
        return FirebaseUserLiveData(
                auth
        ).map { user ->
            if (user != null && user.isEmailVerified) {
                AuthResult.Success(Messages.GENERIC_SUCCESS)

            } else if (user != null && !user.isEmailVerified) {
                auth.signOut()
                AuthResult.Failed(Messages.LOGIN_FAILED)

            } else {
                AuthResult.Failed(Messages.LOGIN_FAILED)
            }
        }
    }


}