package com.olabode.wilson.pytutor.repository.main.user

import androidx.lifecycle.LiveData
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.states.AuthResult
import com.olabode.wilson.pytutor.utils.states.DataState
import kotlinx.coroutines.flow.Flow
import java.io.File

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */

interface UserRepository {

    fun checkLoginStatus(): LiveData<AuthResult<String>>

    fun getLoggedInUserDetails(userId: String): Flow<DataState<User>>

    fun updateCourse(topicKey: String, rating: Float, orderKey: Int): Flow<DataState<String>>

    fun getUserId(): String

    fun updateProfileImage(file: File, userId: String): Flow<DataState<String>>
}