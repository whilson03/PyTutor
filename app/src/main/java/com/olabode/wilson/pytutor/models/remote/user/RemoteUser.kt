package com.olabode.wilson.pytutor.models.remote.user

import com.google.firebase.firestore.ServerTimestamp
import com.olabode.wilson.pytutor.models.Badge
import java.util.*

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */

data class RemoteUser(
        var fullName: String,
        var email: String,
        var level: Int = 0,
        @ServerTimestamp
        var dateJoined: Date? = null,
        var currentXp: Int = 0,
        var badgesAttained: List<Badge> = emptyList(),
        var userId: String,
        var imageUrl: String = "",
        var completedCourses: Map<String, Float> = mapOf(),
        var currentlyUnlockedTopicsId: String? = null
) {

    constructor() : this(
            "",
            "",
            0,
            null,
            0,
            emptyList(),
            "",
            "",
            mapOf(),
            null
    )
}