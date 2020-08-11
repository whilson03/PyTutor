package com.olabode.wilson.pytutor.di

import android.content.Context
import androidx.room.Room
import com.olabode.wilson.pytutor.data.PytutorDatabase
import com.olabode.wilson.pytutor.data.TutorialsDao
import com.olabode.wilson.pytutor.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/11/20.
 */
@Module
@InstallIn(ApplicationComponent::class)
object PersistenceModule {


    @Singleton
    @Provides
    fun providePytutorDatabase(
            @ApplicationContext
            context: Context
    ) = Room.databaseBuilder(
            context, PytutorDatabase::class.java,
            Constants.DATABASE_NAME
    ).build()


    @Singleton
    @Provides
    fun provideMovieDao(database: PytutorDatabase): TutorialsDao {
        return database.tutorialDao()
    }
}