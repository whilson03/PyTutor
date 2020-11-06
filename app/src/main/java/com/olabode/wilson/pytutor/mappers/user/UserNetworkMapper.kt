package com.olabode.wilson.pytutor.mappers.user

import com.olabode.wilson.pytutor.models.remote.user.RemoteUser
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
                level = entity.level,
                userId = entity.userId,
                completedCourses = entity.completedCourses,
                currentlyUnlockedTopicsId = entity.currentlyUnlockedTopicsId
        )
    }

    override fun mapToEntity(domainModel: User): RemoteUser {
        return RemoteUser(
                fullName = domainModel.fullName,
                email = domainModel.email,
                level = domainModel.level,
                dateJoined = null,
                userId = domainModel.userId,
                imageUrl = domainModel.imageUrl,
                completedCourses = domainModel.completedCourses,
                currentlyUnlockedTopicsId = domainModel.currentlyUnlockedTopicsId
        )
    }
}