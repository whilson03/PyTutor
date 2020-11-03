package com.olabode.wilson.pytutor.repository.main.user

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.storage.FirebaseStorage
import com.olabode.wilson.pytutor.data.tutorial.TopicsDao
import com.olabode.wilson.pytutor.data.user.UserDao
import com.olabode.wilson.pytutor.mappers.user.UserCacheMapper
import com.olabode.wilson.pytutor.mappers.user.UserNetworkMapper
import com.olabode.wilson.pytutor.models.remote.user.RemoteUser
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.FirebaseUserLiveData
import com.olabode.wilson.pytutor.utils.Messages
import com.olabode.wilson.pytutor.utils.RemoteDatabaseKeys
import com.olabode.wilson.pytutor.utils.states.AuthResult
import com.olabode.wilson.pytutor.utils.states.DataState
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import java.io.File
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
        private val topicsDao: TopicsDao,
        private val storage: FirebaseStorage
) : UserRepository {
    override fun checkLoginStatus(): LiveData<AuthResult<String>> {
        return FirebaseUserLiveData(
                auth
        ).map { user ->
            if (user == null) {
                AuthResult.Failed(Messages.VERIFY_EMAIL)
            } else if (user.isEmailVerified) {
                AuthResult.Success(Messages.GENERIC_SUCCESS)
            } else if (!user.isEmailVerified) {
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
                offer(
                        DataState.Error(
                                FirebaseException("Failed to Load Profile"),
                                Messages.GENERIC_FAILURE
                        )
                )
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

    override fun updateCourse(
            topicId: String,
            rating: Float,
            nextTopicId: String?
    ): Flow<DataState<String>> = flow {
        emit(DataState.Loading)

        val completedCourse = if (nextTopicId != null) {
            mapOf(topicId to rating, nextTopicId to 0f)
        } else {
            mapOf(topicId to rating)
        }

        topicsDao.updateCompletedCourse(topicId, rating)
        nextTopicId?.let { topicsDao.unlockNextTopic(it) }

        remoteDatabase
                .collection(RemoteDatabaseKeys.NODE_USERS)
                .document(getUserId())
                .set(
                        mapOf(RemoteDatabaseKeys.FIELD_COURSES_COMPLETED to completedCourse),
                        SetOptions.merge()
                ).await()

        emit(DataState.Success(Messages.GENERIC_SUCCESS))
    }.catch { error ->
        emit(DataState.Error(null, error.message.toString()))
        Timber.e(error)
    }.flowOn(Dispatchers.IO)

    override fun getUserId(): String {
        return auth.currentUser!!.uid
    }

    override fun updateProfileImage(file: File, userId: String): Flow<DataState<String>> = flow {
        emit(DataState.Loading)
        val ref = storage.reference.child(RemoteDatabaseKeys.IMAGE_STORAGE_PATH)
                .child(userId)
                .child(RemoteDatabaseKeys.PROFILE_IMAGE_DIR)
                .child(RemoteDatabaseKeys.PROFILE_IMAGE)
        val uploadedImageUrl = ref.putFile(Uri.fromFile(file))
                .await().storage.downloadUrl.await().toString()

        remoteDatabase.collection(RemoteDatabaseKeys.NODE_USERS).document(userId)
                .update(mapOf(RemoteDatabaseKeys.FIELD_PROFILE_IMAGE to uploadedImageUrl))
                .await()

        emit(DataState.Success(Messages.UPLOAD_SUCCESS))
    }.catch {
        emit(DataState.Error(null, Messages.UPLOAD_FAILED))
    }.flowOn(Dispatchers.IO)
}