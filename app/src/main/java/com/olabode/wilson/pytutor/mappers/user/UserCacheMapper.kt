package com.olabode.wilson.pytutor.mappers.user

import com.olabode.wilson.pytutor.models.cache.user.UserCacheEntity
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/20/20.
 */
class UserCacheMapper @Inject constructor() : EntityMapper<UserCacheEntity, User> {
    override fun mapFromEntity(entity: UserCacheEntity): User {
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

    override fun mapToEntity(domainModel: User): UserCacheEntity {
        return UserCacheEntity(
                fullName = domainModel.fullName,
                email = domainModel.email,
                level = domainModel.level,
                userId = domainModel.userId,
                imageUrl = domainModel.imageUrl,
                completedCourses = domainModel.completedCourses,
                currentlyUnlockedTopicsId = domainModel.currentlyUnlockedTopicsId
        )
    }
}