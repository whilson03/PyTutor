package com.olabode.wilson.pytutor.models.cache.tutorial.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.olabode.wilson.pytutor.models.tutorial.Question

/**
 *   Created by OLABODE WILSON on 9/19/20.
 */

class QuestionMapConverter {


    @TypeConverter
    fun fromString(value: String): Map<String, Question>? {
        val mapType = object : TypeToken<Map<String, Question>?>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromStringMap(map: Map<String, Question>?): String {
        val gson = Gson()
        return gson.toJson(map)
    }

}