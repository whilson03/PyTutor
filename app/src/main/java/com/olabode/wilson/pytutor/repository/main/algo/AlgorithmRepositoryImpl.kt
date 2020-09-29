package com.olabode.wilson.pytutor.repository.main.algo

import com.google.firebase.firestore.FirebaseFirestore
import com.olabode.wilson.pytutor.data.algorithm.AlgorithmDao
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/29/20.
 */
class AlgorithmRepositoryImpl @Inject constructor(
        private val remoteDatabase: FirebaseFirestore,
        private val algorithmDao: AlgorithmDao
) : AlgorithmRepository