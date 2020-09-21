package com.olabode.wilson.pytutor.mappers.user

import com.olabode.wilson.pytutor.models.RemoteUser
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/20/20.
 */
class UserNetworkMapper @Inject constructor() : EntityMapper<RemoteUser, User> {

    override fun mapFromEntity(entity: RemoteUser): User {
        return User(
                fullName = entity.fullName,
                email = entity.email,
                imageUrl = entity.imageUrl,
                badges = entity.badgesAttained,
                level = entity.level,
                userId = entity.userId,
                experiencePoint = entity.currentXp
        )
    }

    override fun mapToEntity(domainModel: User): RemoteUser {
        return RemoteUser(
                fullName = domainModel.fullName,
                email = domainModel.email,
                level = domainModel.level,
                currentXp = domainModel.experiencePoint,
                badgesAttained = domainModel.badges,
                dateJoined = null,
                userId = domainModel.userId,
                imageUrl = domainModel.imageUrl
        )
    }
}