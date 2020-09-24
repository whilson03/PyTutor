package com.olabode.wilson.pytutor.repository.main.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.toObject
import com.olabode.wilson.pytutor.data.tutorial.TopicsDao
import com.olabode.wilson.pytutor.data.user.UserDao
import com.olabode.wilson.pytutor.mappers.user.UserCacheMapper
import com.olabode.wilson.pytutor.mappers.user.UserNetworkMapper
import com.olabode.wilson.pytutor.models.remote.user.RemoteUser
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
@ExperimentalCoroutinesApi
@Singleton
class UserRepositoryImpl @Inject constructor(
        private val userNetworkMapper: UserNetworkMapper,
        private val userCacheMapper: UserCacheMapper,
        private val auth: FirebaseAuth,
        private val remoteDatabase: FirebaseFirestore,
        private val userDao: UserDao,
        private val topicsDao: TopicsDao
) : UserRepository {
    override fun checkLoginStatus(): LiveData<AuthResult<String>> {
        return FirebaseUserLiveData(
                auth
        ).map { user ->
            if (user != null && user.isEmailVerified) {
                AuthResult.Success(Messages.GENERIC_SUCCESS)

            } else if (user != null && !user.isEmailVerified) {
                auth.signOut()
                AuthResult.Failed(Messages.VERIFY_EMAIL)

            } else {
                AuthResult.Failed(Messages.LOGIN_FAILED)
            }
        }
    }

    override fun getLoggedInUserDetails(userId: String): Flow<DataState<User>> = callbackFlow {
        offer(DataState.Loading)
        val cachedUser = userDao.getUserById(userId)
        if (cachedUser != null) {
            offer(DataState.Success(userCacheMapper.mapFromEntity(cachedUser)))
        }
        val userRef = remoteDatabase.collection(RemoteDatabaseKeys.NODE_USERS)
                .document(userId)

        val listener = userRef.addSnapshotListener { snapshot, exception ->
            if (snapshot != null && snapshot.exists()) {
                val remoteUser = snapshot.toObject<RemoteUser>()!!
                val user = userNetworkMapper.mapFromEntity(remoteUser)
                offer(DataState.Success(user))
                CoroutineScope(Dispatchers.IO).launch {
                    userDao.insertUser(userCacheMapper.mapToEntity(user))
                }
            }

            // If exception occurs, cancel this scope with exception message.
            exception?.let {
                offer(DataState.Error(FirebaseException("Failed to Load Profile"), Messages.GENERIC_FAILURE))
                cancel()
            }
        }

        awaitClose {
            listener.remove()
            cancel()
        }
    }.catch { e ->
        Timber.e(e)
    }.flowOn(Dispatchers.IO)

    override fun updateCourse(topicKey: String, rating: Float, orderKey: Int): Flow<DataState<String>> = flow {
        emit(DataState.Loading)
        val nextCourseKey = orderKey + 1
        Timber.e(nextCourseKey.toString())

        val completedCourse = mapOf(topicKey to rating)
        topicsDao.updateCompletedCourse(topicKey, rating)
        topicsDao.unlockNextTopic(nextCourseKey)

        remoteDatabase
                .collection(RemoteDatabaseKeys.NODE_USERS)
                .document(getUserId())
                .set(mapOf(RemoteDatabaseKeys.FIELD_COURSES_COMPLETED to completedCourse), SetOptions.merge()).await()

        emit(DataState.Success(Messages.GENERIC_SUCCESS))
    }.catch { error ->
        emit(DataState.Error(null, Messages.GENERIC_FAILURE))
        Timber.e(error)
    }.flowOn(Dispatchers.IO)

    override fun getUserId(): String {
        return auth.currentUser!!.uid
    }

}