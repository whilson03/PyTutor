package com.olabode.wilson.pytutor.di

import com.google.firebase.firestore.FirebaseFirestore
import com.olabode.wilson.pytutor.data.TopicsDao
import com.olabode.wilson.pytutor.mappers.tutorial.TopicCacheMapper
import com.olabode.wilson.pytutor.mappers.tutorial.TopicNetworkMapper
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @ExperimentalCoroutinesApi
    @Singleton
    @Provides
    fun provideTutorialRepository(
            fireStore: FirebaseFirestore,
            networkMapper: TopicNetworkMapper,
            cacheMapper: TopicCacheMapper,
            topicsDao: TopicsDao
    ): TutorialRepository = TutorialRepositoryImpl(
            fireStore,
            networkMapper,
            cacheMapper,
            topicsDao
    )
}