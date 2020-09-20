package com.olabode.wilson.pytutor.files

import com.google.firebase.firestore.FirebaseFirestore
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.TopicResponse
import com.olabode.wilson.pytutor.utils.RemoteDatabaseKeys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

/**
 *   Created by OLABODE WILSON on 9/19/20.
 */

val ref = FirebaseFirestore.getInstance()
        .collection(RemoteDatabaseKeys.NODE_TUTORIALS)

fun uploadCoursesAndLesson(map: Map<TopicResponse, List<LessonResponse>>) {
    CoroutineScope(Dispatchers.IO).launch {
        for (i in map) {
            val topicId = ref.document().id

            val topic = i.key
            topic.topicId = topicId
            topic.noOfPages = i.value.size
            ref.document(topicId).set(topic).await()
            val sub = ref.document(topicId).collection(RemoteDatabaseKeys.NODE_LESSONS)

            for (j in i.value) {
                j.topicId = topicId
                sub.add(j).await()
            }
        }
    }
}


fun dataSet(): Map<TopicResponse, List<LessonResponse>> {
    return mapOf(
            genTopicResponse()[0] to introduction,
            genTopicResponse()[1] to syntax,
            genTopicResponse()[2] to variables,
            genTopicResponse()[3] to strings,
            genTopicResponse()[4] to numbers,
            genTopicResponse()[5] to io,
            genTopicResponse()[6] to dataStructures,
            genTopicResponse()[7] to lists,
            genTopicResponse()[8] to tuples,
            genTopicResponse()[9] to dictionaries,
            genTopicResponse()[10] to sets,
            genTopicResponse()[11] to operators,
            genTopicResponse()[12] to conditions,
            genTopicResponse()[13] to for_loop,
            genTopicResponse()[14] to while_loop,
            genTopicResponse()[15] to loop_keywords,
            genTopicResponse()[16] to functions,
            genTopicResponse()[17] to exception_handling

    )
}
