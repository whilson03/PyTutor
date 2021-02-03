package com.olabode.wilson.pytutor.mappers.tag

import com.olabode.wilson.pytutor.models.Tag
import com.olabode.wilson.pytutor.models.tag.TagResponse
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 2/3/21.
 */

class TagNetworkMapper @Inject constructor() : EntityMapper<TagResponse, Tag> {
    override fun mapFromEntity(entity: TagResponse): Tag {
        return Tag(id = entity.id, title = entity.title)
    }

    override fun mapToEntity(domainModel: Tag): TagResponse {
        return TagResponse(id = domainModel.id, title = domainModel.title)
    }

    fun mapFromEntityList(entities: List<TagResponse>): List<Tag> {
        return entities.map { mapFromEntity(it) }
    }

}