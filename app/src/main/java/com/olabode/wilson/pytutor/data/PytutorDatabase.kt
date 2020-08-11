package com.olabode.wilson.pytutor.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.olabode.wilson.pytutor.models.Tutorial

/**
 *   Created by OLABODE WILSON on 8/11/20.
 */
@Database(entities = [Tutorial::class], version = 1, exportSchema = false)
abstract class PytutorDatabase : RoomDatabase() {
    abstract fun tutorialDao(): TutorialsDao
}
