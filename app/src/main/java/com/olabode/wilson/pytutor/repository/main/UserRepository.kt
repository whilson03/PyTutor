package com.olabode.wilson.pytutor.repository.main

import androidx.lifecycle.LiveData
import com.olabode.wilson.pytutor.utils.AuthResult

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */

interface UserRepository {

    fun checkLoginStatus(): LiveData<AuthResult<String>>
}