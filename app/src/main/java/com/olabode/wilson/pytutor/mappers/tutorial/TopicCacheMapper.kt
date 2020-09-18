package com.olabode.wilson.pytutor.mappers.tutorial

import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.models.cache.tutorial.TopicCacheEntity
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */
class TopicCacheMapper @Inject constructor() : EntityMapper<TopicCacheEntity, Topic> {

    override fun mapFromEntity(entity: TopicCacheEntity): Topic {
        return Topic(
                orderKey = entity.orderKey,
                topicId = entity.topicId,
                title = entity.title,
                description = entity.description,
                isCompleted = entity.isCompleted,
                isLocked = entity.isLocked,
                noOfPages = entity.noOfPages
        )
    }

    override fun mapToEntity(domainModel: Topic): TopicCacheEntity {
        return TopicCacheEntity(
                orderKey = domainModel.orderKey,
                topicId = domainModel.topicId,
                title = domainModel.title,
                description = domainModel.description,
                isCompleted = domainModel.isCompleted,
                isLocked = domainModel.isLocked,
                noOfPages = domainModel.noOfPages
        )
    }


    fun mapFromEntityList(entities: List<TopicCacheEntity>): List<Topic> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}