package com.olabode.wilson.pytutor.data.algorithm

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olabode.wilson.pytutor.models.cache.algorithm.AlgorithmEntity

/**
 *   Created by OLABODE WILSON on 9/27/20.
 */

@Dao
interface AlgorithmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(algorithmEntity: AlgorithmEntity)

    @Query("DELETE FROM algorithm_table")
    suspend fun clear()

    @Query("SELECT * FROM algorithm_table")
    suspend fun getAlgorithms(): List<AlgorithmEntity>
}