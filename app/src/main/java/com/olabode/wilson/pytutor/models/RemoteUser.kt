package com.olabode.wilson.pytutor.models

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */

data class RemoteUser(
        val fullName: String,
        val email: String,
        val level: Int = 0,
        @ServerTimestamp
        val dateJoined: Date? = null,
        val currentXp: Int = 0,
        val badgesAttained: List<Badge>? = null,
        val userId: String,
        val imageUrl: String = ""

) {

    constructor() : this(
            "",
            "",
            0,
            null,
            0,
            null,
            "",
            ""
    )
}