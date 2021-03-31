package com.example.domain.model

data class OpenWeatherData(
    val weather: List<WeatherData>,
    val main: MainData,
    val wind: WindData
) {


    data class WeatherData(
        val id: Long,
        val description: String,
        val icon: String
    )

    data class MainData(
        val temp: Double,
        val feels_like: Double,
        val temp_min: Double,
        val temp_max: Double,
        val pressure: Int,
        val humidity: Int,
        val sea_level: Int,
        val grnd_level: Int
    )

    data class WindData(
        val speed: Double,
        val deg: Double,
        val gust: Double
    )
}