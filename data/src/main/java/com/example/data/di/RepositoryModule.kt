package com.example.data.di

import com.example.data.repository.LocationRepositoryImpl
import com.example.data.repository.WeatherRepositoryImpl
import com.example.data.source.OpenWeatherService
import com.example.data.source.GoogleLocationDataSource
import com.example.data.source.db.AppDatabase
import com.example.domain.repository.LocationRepository
import com.example.domain.repository.OpenWeatherRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {

    @Provides
    fun providesLocationRepository(googleLocationDataSource: GoogleLocationDataSource): LocationRepository {
        return LocationRepositoryImpl(googleLocationDataSource)
    }


    @Provides
    fun providesOpenWeatherRepository(openWeatherService: OpenWeatherService, appDatabase: AppDatabase): OpenWeatherRepository {
        return WeatherRepositoryImpl(openWeatherService,appDatabase);
    }
}