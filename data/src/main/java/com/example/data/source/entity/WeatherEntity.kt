package com.example.data.source.entity

import androidx.room.*
import com.example.domain.model.OpenWeatherData

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    val weather: List<WeatherData>,
    @Embedded(prefix = "main")
    val main: MainData,
    @Embedded(prefix = "wind")
    val wind: WindData
) {

    data class WeatherData(
        val id: Long,
        val description: String,
        val icon: String
    ) {

        companion object {

            fun create(data: OpenWeatherData.WeatherData): WeatherData {
                return WeatherData(data.id, data.description, data.icon)
            }
        }
    }

    data class MainData(
        val temp: Double,
        val feels_like: Double,
        val temp_min: Double,
        val temp_max: Double,
        val pressure: Int,
        val humidity: Int,
        val sea_level: Int,
        val grnd_level: Int
    ) {
        companion object {

            fun create(data: OpenWeatherData.MainData): MainData {
                return MainData(
                    data.temp,
                    data.feels_like,
                    data.temp_min,
                    data.temp_max,
                    data.pressure,
                    data.humidity,
                    data.sea_level,
                    data.grnd_level
                )
            }
        }
    }

    data class WindData(
        val speed: Double,
        val deg: Double,
        val gust: Double
    ) {

        companion object {

            fun create(data: OpenWeatherData.WindData): WindData {
                return WindData(data.speed, data.deg, data.gust)
            }

        }
    }


    fun toDomain(): OpenWeatherData {

        return OpenWeatherData(
            weather.map { OpenWeatherData.WeatherData(it.id, it.description, it.icon) },
            OpenWeatherData.MainData(
                main.temp,
                main.feels_like,
                main.temp_min,
                main.temp_max,
                main.pressure,
                main.humidity,
                main.sea_level,
                main.grnd_level
            ),
            OpenWeatherData.WindData(
                wind.speed,
                wind.deg,
                wind.gust,
            )
        )

    }

    companion object {
        const val PUBLIC_ID = 1111

        fun create(data: OpenWeatherData): WeatherEntity {
            return WeatherEntity(
                PUBLIC_ID,
                data.weather.map { WeatherData.create(it) },
                MainData.create(data.main),
                WindData.create(data.wind)
            );
        }
    }

}