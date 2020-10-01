package com.olabode.wilson.pytutor.repository.main.algo

import com.olabode.wilson.pytutor.models.Algorithm
import com.olabode.wilson.pytutor.utils.states.DataState
import kotlinx.coroutines.flow.Flow

/**
 *   Created by OLABODE WILSON on 9/29/20.
 */
interface AlgorithmRepository {

    fun fectchAllAlgorithms(): Flow<DataState<List<Algorithm>>>
}