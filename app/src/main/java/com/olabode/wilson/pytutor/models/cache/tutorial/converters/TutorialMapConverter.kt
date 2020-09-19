package com.olabode.wilson.pytutor.models.cache.tutorial.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.olabode.wilson.pytutor.models.tutorial.Tutorial

/**
 *   Created by OLABODE WILSON on 9/19/20.
 */
class TutorialMapConverter {


    @TypeConverter
    fun fromString(value: String): Map<String, Tutorial>? {
        val mapType = object : TypeToken<Map<String, Tutorial>?>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromStringMap(map: Map<String, Tutorial>?): String {
        val gson = Gson()
        return gson.toJson(map)
    }

}