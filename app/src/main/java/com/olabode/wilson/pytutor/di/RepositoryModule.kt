package com.olabode.wilson.pytutor.di

import com.google.firebase.firestore.FirebaseFirestore
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTutorialRepository(
            firestore: FirebaseFirestore
    ): TutorialRepository = TutorialRepositoryImpl(
            firestore
    )
}