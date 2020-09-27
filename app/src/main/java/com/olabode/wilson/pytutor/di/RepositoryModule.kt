package com.olabode.wilson.pytutor.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.olabode.wilson.pytutor.data.tutorial.LessonsDao
import com.olabode.wilson.pytutor.data.tutorial.TopicsDao
import com.olabode.wilson.pytutor.data.user.UserDao
import com.olabode.wilson.pytutor.mappers.tutorial.LessonCacheMapper
import com.olabode.wilson.pytutor.mappers.tutorial.LessonNetworkMapper
import com.olabode.wilson.pytutor.mappers.tutorial.TopicCacheMapper
import com.olabode.wilson.pytutor.mappers.tutorial.TopicNetworkMapper
import com.olabode.wilson.pytutor.mappers.user.UserCacheMapper
import com.olabode.wilson.pytutor.mappers.user.UserNetworkMapper
import com.olabode.wilson.pytutor.repository.auth.AuthRepository
import com.olabode.wilson.pytutor.repository.auth.AuthRepositoryImpl
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepositoryImpl
import com.olabode.wilson.pytutor.repository.main.user.UserRepository
import com.olabode.wilson.pytutor.repository.main.user.UserRepositoryImpl
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
            topicsDao: TopicsDao,
            topicNetworkMapper: TopicNetworkMapper,
            topicCacheMapper: TopicCacheMapper,
            lessonNetworkMapper: LessonNetworkMapper,
            lessonCacheMapper: LessonCacheMapper,
            lessonsDao: LessonsDao
    ): TutorialRepository = TutorialRepositoryImpl(
            remoteDatabase = fireStore,
            topicNetworkMapper = topicNetworkMapper,
            topicCacheMapper = topicCacheMapper,
            topicsDao = topicsDao,
            lessonNetworkMapper = lessonNetworkMapper,
            lessonsCacheMapper = lessonCacheMapper,
            lessonsDao = lessonsDao
    )


    @Singleton
    @Provides
    fun provideAuthRepository(
            firebaseAuth: FirebaseAuth,
            firestore: FirebaseFirestore
    ): AuthRepository = AuthRepositoryImpl(
            firebaseAuth,
            firestore
    )

    @Singleton
    @Provides
    fun provideUserRepository(
            userNetworkMapper: UserNetworkMapper,
            userCacheMapper: UserCacheMapper,
            firebaseAuth: FirebaseAuth,
            firestore: FirebaseFirestore,
            userDao: UserDao,
            topicsDao: TopicsDao,
            storage: FirebaseStorage
    ): UserRepository = UserRepositoryImpl(
            userNetworkMapper,
            userCacheMapper,
            firebaseAuth,
            firestore,
            userDao,
            topicsDao,
            storage
    )
}