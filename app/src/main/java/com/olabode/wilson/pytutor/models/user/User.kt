package com.olabode.wilson.pytutor.models.user

import com.olabode.wilson.pytutor.models.Badge

/**
 *   Created by OLABODE WILSON on 9/20/20.
 */

data class User(
        val fullName: String,
        val email: String,
        val level: Int = 0,
        val experiencePoint: Int = 0,
        val imageUrl: String,
        val badges: List<Badge>,
        val userId: String,
        val completedCourses: Map<String, Float>
) {

    fun getUserProgress(): Int {
        // Convert completed lessons to percentage
        return (100 / 18f * this.completedCourses.size).toInt()

//        Using the decrementing method:
//        val completedCourses = this.completedCourses.size - 1
//        return if (completedCourses > 0) {
//            (100 / 18f * completedCourses).toInt()
//        }
//        else {
//            0
//        }
    }
}