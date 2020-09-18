package com.olabode.wilson.pytutor.utils

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(domainModel: DomainModel): Entity

}