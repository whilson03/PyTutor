package com.olabode.wilson.pytutor.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.olabode.wilson.pytutor.repository.auth.AuthRepository
import com.olabode.wilson.pytutor.repository.auth.AuthRepositoryImpl
import com.olabode.wilson.pytutor.repository.main.UserRepository
import com.olabode.wilson.pytutor.repository.main.UserRepositoryImpl
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

    @Singleton
    @Provides
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun provideFirebaseFireStore() = Firebase.firestore


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
            firebaseAuth: FirebaseAuth,
            firestore: FirebaseFirestore
    ): UserRepository = UserRepositoryImpl(
            firebaseAuth,
            firestore
    )

}