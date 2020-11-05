package com.olabode.wilson.pytutor.data.exercise

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olabode.wilson.pytutor.models.cache.exercise.ExerciseEntity

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */

@Dao
interface ExerciseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exerciseEntity: ExerciseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(exerciseEntity: List<ExerciseEntity>)

    @Query("DELETE FROM exercise_table")
    suspend fun clear()

    @Query("SELECT * FROM exercise_table ORDER BY difficulty ASC")
    suspend fun retrieveExercises(): List<ExerciseEntity>
}