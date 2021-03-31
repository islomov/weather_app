package com.example.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.*
import com.example.domain.model.OpenWeatherData
import com.example.domain.usecase.LocationUseCase
import com.example.domain.usecase.WeatherUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val weatherUseCase: WeatherUseCase,
    locationUseCase: LocationUseCase
) : BaseViewModel() {


    private val _weatherData = MutableLiveData<ResponseData<OpenWeatherData>>()
    val weatherData: LiveData<ResponseData<OpenWeatherData>> = _weatherData

    fun getWeather(lat: Double, lon: Double) {
        weatherUseCase
            .getWeather(lat, lon)
            .doOnSubscribe {
                _weatherData.value = dataLoading(null)
            }
            .baseSubscribe(
                onSuccess = {
                    _weatherData.value = dataSuccess(it)
                },
                onError = {
                    _weatherData.value = dataError(it.localizedMessage, null)
                }
            )
    }


}