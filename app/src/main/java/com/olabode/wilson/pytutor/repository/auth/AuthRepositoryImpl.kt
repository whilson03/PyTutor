package com.olabode.wilson.pytutor.repository.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.olabode.wilson.pytutor.models.User
import com.olabode.wilson.pytutor.utils.AuthResult
import com.olabode.wilson.pytutor.utils.Constants
import com.olabode.wilson.pytutor.utils.Messages
import com.olabode.wilson.pytutor.utils.RemoteDatabaseKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */

@Singleton
class AuthRepositoryImpl @Inject constructor(
        private val auth: FirebaseAuth,
        private val remoteDatabase: FirebaseFirestore
) : AuthRepository {

    override fun loginUser(
            email: String,
            password: String
    ): Flow<AuthResult<String>> = flow {
        emit(AuthResult.Loading)
        val login = auth.signInWithEmailAndPassword(email, password).await()
        val user = login.user!!

        if (user.isEmailVerified) {
            emit(AuthResult.Success(Messages.GENERIC_SUCCESS))
        } else {
            emit(AuthResult.Failed(Messages.VERIFY_EMAIL))
            logOut()
            return@flow
        }

    }.catch { e ->
        Timber.e(e)
        emit(AuthResult.Failed(Messages.LOGIN_FAILED))
    }.flowOn(Dispatchers.IO)

    override fun registerNewUser(
            fullName: String,
            email: String,
            password: String,
            confirmPassword: String
    ): Flow<AuthResult<String>> = flow {
        emit(AuthResult.Loading)
        if (password.length < Constants.PASSWORD_LENGTH) {
            emit(AuthResult.Failed(Messages.SHORT_PASSWORD))
            return@flow
        }

        if (password != confirmPassword) {
            emit(AuthResult.Failed(Messages.MISMATCH_PASSWORD))
            return@flow
        }

        val registerUser = auth.createUserWithEmailAndPassword(email, password).await()
        val firebaseUser = registerUser.user!!
        val user = User(fullName = fullName, email = email, userId = firebaseUser.uid)
        remoteDatabase.collection(RemoteDatabaseKeys.NODE_USERS).document(firebaseUser.uid)
                .set(user).await()
        sendEmailVerificationLink(firebaseUser)
        emit(AuthResult.Success(Messages.ACCOUNT_CREATION_SUCCESS))
        logOut()
    }.catch { e ->
        logOut()
        when (e) {
            is FirebaseAuthUserCollisionException -> emit(AuthResult.Failed(Messages.ACCOUNT_IN_USE_FAILURE))
            else -> emit(AuthResult.Failed(Messages.ACCOUNT_CREATION_FAILURE))
        }

    }.flowOn(Dispatchers.IO)


    override fun logOut(): Flow<AuthResult<String>> = flow {
        emit(AuthResult.Loading)
        auth.signOut()
        emit(AuthResult.Success(Messages.GENERIC_SUCCESS))
    }.flowOn(Dispatchers.IO)

    override suspend fun sendEmailVerificationLink(firebaseUser: FirebaseUser) {
        withContext(Dispatchers.IO) {
            firebaseUser.sendEmailVerification().await()
        }
    }

    override fun currentUserId(): String {
        return auth.currentUser!!.uid
    }
}