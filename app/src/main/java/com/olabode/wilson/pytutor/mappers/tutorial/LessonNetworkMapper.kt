package com.olabode.wilson.pytutor.mappers.tutorial

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */
class LessonNetworkMapper @Inject constructor() :
    EntityMapper<LessonResponse, Lesson> {

    override fun mapFromEntity(entity: LessonResponse): Lesson {
        return Lesson(
            topicId = entity.topicId,
            page = entity.page,
            lessons = entity.lessons,
            question = entity.question,
            type = entity.type
        )
    }

    override fun mapToEntity(domainModel: Lesson): LessonResponse {
        return LessonResponse(
            topicId = domainModel.topicId,
            page = domainModel.page,
            lessons = domainModel.lessons,
            question = domainModel.question,
            type = domainModel.type
        )
    }

    fun mapFromEntityList(entities: List<LessonResponse>): List<Lesson> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}