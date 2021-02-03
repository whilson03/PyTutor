package com.olabode.wilson.pytutor.mappers.exercise

import com.olabode.wilson.pytutor.models.Exercise
import com.olabode.wilson.pytutor.models.cache.exercise.ExerciseEntity
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */

class ExerciseCacheMapper @Inject constructor() : EntityMapper<ExerciseEntity, Exercise> {
    override fun mapFromEntity(entity: ExerciseEntity): Exercise {
        return Exercise(
                id = entity.id,
                title = entity.title,
                difficulty = entity.difficulty,
                question = entity.question,
                solution = entity.solution,
                postedBy = entity.postedBy,
                datePosted = entity.datePosted,
                tags = entity.tags
        )
    }

    override fun mapToEntity(domainModel: Exercise): ExerciseEntity {
        return ExerciseEntity(
                id = domainModel.id,
                title = domainModel.title,
                difficulty = domainModel.difficulty,
                question = domainModel.question,
                solution = domainModel.solution,
                postedBy = domainModel.postedBy,
                datePosted = domainModel.datePosted,
                tags = domainModel.tags
        )
    }

    fun mapFromEntityList(entities: List<ExerciseEntity>): List<Exercise> {
        return entities.map {
            mapFromEntity(it)
        }
    }

    fun mapToEntityList(domainModels: List<Exercise>): List<ExerciseEntity> {
        return domainModels.map {
            mapToEntity(it)
        }
    }
}