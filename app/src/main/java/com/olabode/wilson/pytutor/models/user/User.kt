package com.olabode.wilson.pytutor.models.user

/**
 *   Created by OLABODE WILSON on 9/20/20.
 */

data class User(
        val fullName: String,
        val email: String,
        val level: Int = 0,
        val imageUrl: String,
        val userId: String,
        val completedCourses: Map<String, Float>,
        var currentlyUnlockedTopicsId: String? = null
) {

    fun getUserProgress(): Int {
        // Convert completed lessons to percentage
        return (100 / 18f * this.completedCourses.size).toInt()
    }
}