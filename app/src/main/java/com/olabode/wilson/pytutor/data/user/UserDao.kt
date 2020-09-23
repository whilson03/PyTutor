package com.olabode.wilson.pytutor.data.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olabode.wilson.pytutor.models.cache.user.UserCacheEntity

/**
 *   Created by OLABODE WILSON on 9/20/20.
 */

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserCacheEntity)

    @Query("SELECT * FROM USER_TABLE WHERE user_id=:userId")
    suspend fun getUserById(userId: String): UserCacheEntity?

    @Query("UPDATE user_table SET level=:progress  WHERE user_id=:userId")
    suspend fun updateUserProgress(progress: Int, userId: String)


}