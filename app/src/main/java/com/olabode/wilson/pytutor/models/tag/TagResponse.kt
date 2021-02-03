package com.olabode.wilson.pytutor.models.tag

/**
 *   Created by OLABODE WILSON on 2/3/21.
 */

data class TagResponse(
        var id: String,
        val title: String
) {
    constructor() : this("", "")
}