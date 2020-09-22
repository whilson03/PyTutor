package com.olabode.wilson.pytutor.repository.main.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.olabode.wilson.pytutor.data.user.UserDao
import com.olabode.wilson.pytutor.mappers.user.UserCacheMapper
import com.olabode.wilson.pytutor.mappers.user.UserNetworkMapper
import com.olabode.wilson.pytutor.models.RemoteUser
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
@Singleton
class UserRepositoryImpl @Inject constructor(
        private val userNetworkMapper: UserNetworkMapper,
        private val userCacheMapper: UserCacheMapper,
        private val auth: FirebaseAuth,
        private val remoteDatabase: FirebaseFirestore,
        private val userDao: UserDao
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

    override fun getLoggedInUserDetails(userId: String): Flow<DataState<User>> = flow {
        emit(DataState.Loading)

        val cachedUser = userDao.getUserById(userId)
        if (cachedUser != null) {
            emit(DataState.Success(userCacheMapper.mapFromEntity(cachedUser)))
        } else {
            val userRef = remoteDatabase.collection(RemoteDatabaseKeys.NODE_USERS)
                    .document(userId).get().await()
            val remoteUser = userRef.toObject<RemoteUser>()
            remoteUser?.let {
                val user = userNetworkMapper.mapFromEntity(it)
                val userEntity = userCacheMapper.mapToEntity(user)
                userDao.insertUser(userEntity)
                emit(DataState.Success(user))
            } ?: emit(DataState.Error(null, Messages.GENERIC_FAILURE))
        }
    }.catch { e ->
        emit(DataState.Error(null, Messages.GENERIC_FAILURE))
        Timber.e(e)
    }.flowOn(Dispatchers.IO)

}