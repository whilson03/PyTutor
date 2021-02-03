package com.olabode.wilson.pytutor.repository.main.tag

import com.olabode.wilson.pytutor.models.Tag
import com.olabode.wilson.pytutor.utils.states.DataState
import kotlinx.coroutines.flow.Flow

/**
 *   Created by OLABODE WILSON on 2/3/21.
 */
interface TagRepository {

    fun getAllTags(): Flow<DataState<List<Tag>>>

}