package com.example.data.source

import com.example.data.BuildConfig
import com.example.domain.model.OpenWeatherData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherService {


    @GET("weather")
    fun getWeather(@Query("lat") lat:Double,
                   @Query("lat") long:Double,
                    @Query("appid") key:String = BuildConfig.APP_ID): Single<OpenWeatherData>

}