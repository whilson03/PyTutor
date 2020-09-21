package com.olabode.wilson.pytutor.repository.main.user

import androidx.lifecycle.LiveData
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.AuthResult
import com.olabode.wilson.pytutor.utils.DataState
import kotlinx.coroutines.flow.Flow


/**
 *   Created by OLABODE WILSON on 9/6/20.
 */

interface UserRepository {

    fun checkLoginStatus(): LiveData<AuthResult<String>>

    fun getLoggedInUserDetails(userId: String): Flow<DataState<User>>
}