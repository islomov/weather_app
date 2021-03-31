package com.example.domain.repository

import com.example.domain.model.LocationData
import com.example.domain.model.OpenWeatherData
import io.reactivex.Single

interface OpenWeatherRepository  {
    fun getWeather(locationData: LocationData): Single<OpenWeatherData>
}