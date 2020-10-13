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
            solution = entity.solution
        )
    }

    override fun mapToEntity(domainModel: Exercise): ExerciseEntity {
        return ExerciseEntity(
            id = domainModel.id,
            title = domainModel.title,
            difficulty = domainModel.difficulty,
            question = domainModel.question,
            solution = domainModel.solution
        )
    }

    fun mapFromEntityList(entities: List<ExerciseEntity>): List<Exercise> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}