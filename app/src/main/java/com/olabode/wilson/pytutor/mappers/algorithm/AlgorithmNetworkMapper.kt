package com.olabode.wilson.pytutor.mappers.algorithm

import com.olabode.wilson.pytutor.models.Algorithm
import com.olabode.wilson.pytutor.models.remote.algorithm.AlgorithmResponse
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/27/20.
 */
class AlgorithmNetworkMapper @Inject constructor() : EntityMapper<AlgorithmResponse, Algorithm> {

    override fun mapFromEntity(entity: AlgorithmResponse): Algorithm {
        return Algorithm(
                id = entity.id,
                title = entity.title,
                description = entity.description,
                body = entity.body
        )
    }

    override fun mapToEntity(domainModel: Algorithm): AlgorithmResponse {
        return AlgorithmResponse(
                id = domainModel.id,
                title = domainModel.title,
                description = domainModel.description,
                body = domainModel.body
        )
    }

    fun mapFromEntityList(entities: List<AlgorithmResponse>): List<Algorithm> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}