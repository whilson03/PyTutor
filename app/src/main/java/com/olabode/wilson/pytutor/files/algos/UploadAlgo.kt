package com.olabode.wilson.pytutor.files.algos

import com.google.firebase.firestore.FirebaseFirestore
import com.olabode.wilson.pytutor.models.remote.algorithm.AlgorithmResponse
import com.olabode.wilson.pytutor.utils.RemoteDatabaseKeys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

/**
 *   Created by OLABODE WILSON on 10/6/20.
 */

val ref = FirebaseFirestore.getInstance()
    .collection(RemoteDatabaseKeys.NODE_ALGORITHMS)

fun uploadAlgos(algos: List<AlgorithmResponse>) {
    CoroutineScope(Dispatchers.IO).launch {
        for (i in algos) {
            val id = ref.document().id
            i.id = id
            ref.document(id).set(i).await()
        }
    }
}