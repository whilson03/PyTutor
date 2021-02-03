package com.olabode.wilson.pytutor.models.cache.exercise

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */
@Entity(tableName = "exercise_table")
data class ExerciseEntity(

        @ColumnInfo(name = "id")
        @PrimaryKey(autoGenerate = false)
        val id: String,

        @ColumnInfo(name = "title")
        val title: String,

        @ColumnInfo(name = "difficulty")
        val difficulty: Int,

        @ColumnInfo(name = "question")
        val question: String,

        @ColumnInfo(name = "solution")
        val solution: String,

        @ColumnInfo(name = "posted_by")
        val postedBy: String,

        @ColumnInfo(name = "tags")
        val tags: Map<Int, String>,

        @ColumnInfo(name = "date_posted")
        val datePosted: String
)