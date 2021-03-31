package com.example.data.repository

import com.example.data.source.OpenWeatherService
import com.example.data.source.db.AppDatabase
import com.example.data.source.entity.WeatherEntity
import com.example.domain.model.LocationData
import com.example.domain.model.OpenWeatherData
import com.example.domain.repository.OpenWeatherRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val openWeatherService: OpenWeatherService,
    private val appDatabase: AppDatabase
) : OpenWeatherRepository {

    override fun getWeather(locationData: LocationData): Single<OpenWeatherData> {
        val weatherDao = appDatabase.weatherDao()
        return openWeatherService.getWeather(
            locationData.latitude,
            locationData.longitude
        ).doOnSuccess {
            weatherDao.insertData(WeatherEntity.create(it))
        }.onErrorResumeNext(weatherDao.queryData().map { it.toDomain() }.toSingle())
    }

}

