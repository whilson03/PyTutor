package com.olabode.wilson.pytutor.models.cache.exercise

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 *   Created by OLABODE WILSON on 2/3/21.
 */
class ExercisesTagConverter {

    @TypeConverter
    fun fromString(value: String): Map<Int, String> {
        val mapType: Type = object : TypeToken<Map<Int, String>>() {}.type
        return Gson().fromJson<Map<Int, String>>(value, mapType)
    }

    @TypeConverter
    fun fromStringMap(map: Map<Int, String>): String {
        val gson = Gson()
        return gson.toJson(map)
    }
}