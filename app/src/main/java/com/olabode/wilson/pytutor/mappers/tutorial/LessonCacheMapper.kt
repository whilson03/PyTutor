package com.olabode.wilson.pytutor.mappers.tutorial

import com.olabode.wilson.pytutor.models.cache.tutorial.LessonCacheEntity
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

class LessonCacheMapper @Inject constructor() :
    EntityMapper<LessonCacheEntity, Lesson> {

    override fun mapFromEntity(entity: LessonCacheEntity): Lesson {
        return Lesson(
            topicId = entity.topicId,
            page = entity.page,
            lessons = entity.lessons,
            question = entity.question,
            type = entity.type
        )
    }

    override fun mapToEntity(domainModel: Lesson): LessonCacheEntity {
        return LessonCacheEntity(
            topicId = domainModel.topicId,
            page = domainModel.page,
            lessons = domainModel.lessons,
            question = domainModel.question,
            type = domainModel.type,
            lessonId = 0
        )
    }

    fun mapFromEntityList(entities: List<LessonCacheEntity>): List<Lesson> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}