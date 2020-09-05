package com.olabode.wilson.pytutor.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.olabode.wilson.pytutor.repository.UserRepository
import com.olabode.wilson.pytutor.repository.UserRepositoryImpl
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
    fun provideUserRepository(
            firebaseAuth: FirebaseAuth,
            firestore: FirebaseFirestore
    ): UserRepository = UserRepositoryImpl(
            firebaseAuth,
            firestore
    )


}