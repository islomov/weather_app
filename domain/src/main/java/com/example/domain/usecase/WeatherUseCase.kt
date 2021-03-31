package com.example.domain.usecase

import com.example.domain.model.LocationData
import com.example.domain.model.OpenWeatherData
import com.example.domain.repository.OpenWeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val openWeatherRepository: OpenWeatherRepository) {


    fun getWeather(lat: Double, lon: Double): Single<OpenWeatherData> {
        return openWeatherRepository
            .getWeather(LocationData(lat, lon))

    }

}