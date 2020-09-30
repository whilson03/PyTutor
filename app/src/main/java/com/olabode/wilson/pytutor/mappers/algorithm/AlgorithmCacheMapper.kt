package com.olabode.wilson.pytutor.mappers.algorithm

import com.olabode.wilson.pytutor.models.Algorithm
import com.olabode.wilson.pytutor.models.cache.algorithm.AlgorithmEntity
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/27/20.
 */
class AlgorithmCacheMapper @Inject constructor() : EntityMapper<AlgorithmEntity, Algorithm> {
    override fun mapFromEntity(entity: AlgorithmEntity): Algorithm {
        return Algorithm(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            body = entity.body
        )
    }

    override fun mapToEntity(domainModel: Algorithm): AlgorithmEntity {
        return AlgorithmEntity(
            id = domainModel.id,
            title = domainModel.title,
            description = domainModel.description,
            body = domainModel.body
        )
    }

    fun mapFromEntityList(entities: List<AlgorithmEntity>): List<Algorithm> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}