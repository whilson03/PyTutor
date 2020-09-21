package com.olabode.wilson.pytutor.models.cache.user

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.olabode.wilson.pytutor.models.Badge

/**
 *   Created by OLABODE WILSON on 9/21/20.
 */
class UserBadgeTypeConverter {

    @TypeConverter
    fun fromBadgesList(value: List<Badge>?): String {
        val gson = Gson()
        val type = object : TypeToken<List<Badge>?>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toBadgesList(value: String): List<Badge>? {
        val gson = Gson()
        val type = object : TypeToken<List<Badge>?>() {}.type
        return gson.fromJson(value, type)
    }
}