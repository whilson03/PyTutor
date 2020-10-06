package com.olabode.wilson.pytutor.models.remote.algorithm

/**
 *   Created by OLABODE WILSON on 9/27/20.
 */
data class AlgorithmResponse(
    var id: String,
    val title: String,
    val description: String,
    val body: String
) {
    constructor() : this("", "", "", "")
}