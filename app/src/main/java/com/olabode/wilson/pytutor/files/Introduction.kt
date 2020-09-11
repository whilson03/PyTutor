package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.models.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/10/20.
 */


//fun uploadLesson(id: String) {
//    val ref = FirebaseFirestore.getInstance()
//            .collection(RemoteDatabaseKeys.NODE_TUTORIALS)
//            .document(RemoteDatabaseKeys.DOC_LESSONS)
//            .collection(id)
//    CoroutineScope(Dispatchers.IO).launch {
//        ref.add(introduction[0])
//    }
//}


// this is the format for each lesson
// CREATE EACH FILES BASED ON TOPIC AND FOLLOW THIS FORMAT

val introduction = listOf(
        LessonResponse(
                1,
                lessons = mapOf(
                        "1" to Lesson(
                                1, // this key is used to make sure the lessons are displayed in correct order in the recycler view
                                "",
                                "Hello world",
                                null,
                                LessonTypes.TEXT.ordinal // NB: Dont Forget to specify type
                        )//  add more lessons (TEXT , IMAGE, or CODE) that will be displayed in the recycler view for this page
                ),
                question = null, // null because its a lesson type, so recycler view will be used , else show quiz UI
                type = LessonResponseType.LESSON.ordinal // DETERMINES WHETHER ITS A LESSON OR QUESTION
        )
        //,

        // LessonResponse ( another page NB  Question should always be the last Page
)