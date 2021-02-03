package com.olabode.wilson.pytutor.di

import com.olabode.wilson.pytutor.repository.auth.AuthRepository
import com.olabode.wilson.pytutor.repository.auth.AuthRepositoryImpl
import com.olabode.wilson.pytutor.repository.main.algo.AlgorithmRepository
import com.olabode.wilson.pytutor.repository.main.algo.AlgorithmRepositoryImpl
import com.olabode.wilson.pytutor.repository.main.exercise.ExerciseRepository
import com.olabode.wilson.pytutor.repository.main.exercise.ExerciseRepositoryImpl
import com.olabode.wilson.pytutor.repository.main.tag.TagRepository
import com.olabode.wilson.pytutor.repository.main.tag.TagRepositoryImpl
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepositoryImpl
import com.olabode.wilson.pytutor.repository.main.user.UserRepository
import com.olabode.wilson.pytutor.repository.main.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
@Module
@ExperimentalCoroutinesApi
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {


    @Singleton
    @Binds
    abstract fun provideTutorialRepository(tutorialRepositoryImpl: TutorialRepositoryImpl): TutorialRepository

    @Singleton
    @Binds
    abstract fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository


    @Singleton
    @Binds
    abstract fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Singleton
    @Binds
    abstract fun provideAlgorithmRepository(
            algorithmRepositoryImpl: AlgorithmRepositoryImpl
    ): AlgorithmRepository

    @Singleton
    @Binds
    abstract fun provideExerciseRepository(
            exerciseRepositoryImpl: ExerciseRepositoryImpl): ExerciseRepository


    @Singleton
    @Binds
    abstract fun provideTagsRepository(tagRepositoryImpl: TagRepositoryImpl): TagRepository

}