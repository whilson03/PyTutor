package com.olabode.wilson.pytutor.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.olabode.wilson.pytutor.data.PytutorDatabase
import com.olabode.wilson.pytutor.data.tutorial.LessonsDao
import com.olabode.wilson.pytutor.data.tutorial.TopicsDao
import com.olabode.wilson.pytutor.data.user.UserDao
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
object AppModule {

    @Singleton
    @Provides
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun provideFirebaseFireStore() = Firebase.firestore

    @Singleton
    @Provides
    fun provideFirebaseStorage() = Firebase.storage

    @Singleton
    @Provides
    fun providePytutorDatabase(
            @ApplicationContext
            context: Context
    ) = Room.databaseBuilder(
            context, PytutorDatabase::class.java,
            Constants.DATABASE_NAME
    ).fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideTopicsDao(database: PytutorDatabase): TopicsDao {
        return database.topicDao()
    }

    @Singleton
    @Provides
    fun provideLessonDao(database: PytutorDatabase): LessonsDao {
        return database.lessonDao()
    }

    @Singleton
    @Provides
    fun provideUserDao(database: PytutorDatabase): UserDao {
        return database.userDao()
    }
}