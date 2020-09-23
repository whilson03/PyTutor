package com.olabode.wilson.pytutor.models.cache.user

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


/**
 *   Created by OLABODE WILSON on 9/22/20.
 */
class UserCompletedCoursesConverter {

    @TypeConverter
    fun fromString(value: String): Map<String, Float> {
        val mapType: Type = object : TypeToken<Map<String, Float>>() {}.type
        return Gson().fromJson<Map<String, Float>>(value, mapType)
    }

    @TypeConverter
    fun fromStringMap(map: Map<String, Float>): String {
        val gson = Gson()
        return gson.toJson(map)
    }
}