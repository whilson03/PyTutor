package com.olabode.wilson.pytutor.mappers.exercise

import com.olabode.wilson.pytutor.models.Exercise
import com.olabode.wilson.pytutor.models.remote.exercise.ExerciseResponse
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */

class ExerciseNetworkMapper @Inject constructor() : EntityMapper<ExerciseResponse, Exercise> {
    override fun mapFromEntity(entity: ExerciseResponse): Exercise {
        return Exercise(
            id = entity.id,
            title = entity.title,
            difficulty = entity.difficulty,
            question = entity.question,
            solution = entity.solution
        )
    }

    override fun mapToEntity(domainModel: Exercise): ExerciseResponse {
        return ExerciseResponse(
            id = domainModel.id,
            title = domainModel.title,
            difficulty = domainModel.difficulty,
            question = domainModel.question,
            solution = domainModel.solution
        )
    }

    fun mapFromEntityList(entities: List<ExerciseResponse>): List<Exercise> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}