package com.olabode.wilson.pytutor.di

import com.olabode.wilson.pytutor.data.TutorialsDao
import com.olabode.wilson.pytutor.repository.learn.LearnRepository
import com.olabode.wilson.pytutor.repository.learn.LearnRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/11/20.
 */

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTutorialRepository(
            tutorialsDao: TutorialsDao
    ): LearnRepository =
            LearnRepositoryImpl(
                    tutorialsDao
            )
}