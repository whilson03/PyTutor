package com.olabode.wilson.pytutor.repository.main.tutorial

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
@Singleton
class TutorialRepositoryImpl @Inject constructor(private val firestore: FirebaseFirestore)
    : TutorialRepository