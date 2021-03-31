package com.example.data.source.converters

import androidx.room.TypeConverter
import com.example.data.source.entity.WeatherEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class WeatherDataConverter {

    var gson = Gson()

    @TypeConverter
    fun toList(data: String?): List<WeatherEntity.WeatherData> {
        if (data == null) {
            return Collections.emptyList()
        }
        val type = object : TypeToken<List<WeatherEntity.WeatherData>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun toJson(list: List<WeatherEntity.WeatherData>?): String {
        return gson.toJson(list)
    }
}