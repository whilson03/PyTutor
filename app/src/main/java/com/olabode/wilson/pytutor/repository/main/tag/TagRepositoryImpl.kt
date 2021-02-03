package com.olabode.wilson.pytutor.repository.main.tag

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.olabode.wilson.pytutor.mappers.tag.TagNetworkMapper
import com.olabode.wilson.pytutor.models.Tag
import com.olabode.wilson.pytutor.models.tag.TagResponse
import com.olabode.wilson.pytutor.utils.Messages
import com.olabode.wilson.pytutor.utils.RemoteDatabaseKeys
import com.olabode.wilson.pytutor.utils.states.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 2/3/21.
 */
class TagRepositoryImpl @Inject constructor(
        private val tagNetworkMapper: TagNetworkMapper,
        private val remoteDatabase: FirebaseFirestore
) : TagRepository {

    override fun getAllTags(): Flow<DataState<List<Tag>>> = flow {
        emit(DataState.Loading)
        val remoteTags = remoteDatabase
                .collection(RemoteDatabaseKeys.NODE_TAGS)
                .get().await().documents

        val tags = tagNetworkMapper.mapFromEntityList(remoteTags.map { it?.toObject<TagResponse>()!! })
        emit(DataState.Success(tags))

    }.catch {
        emit(DataState.Error(null, Messages.FAILED_TO_LOAD_TAGS))
    }.flowOn(Dispatchers.IO)
}