package com.example.data.repository

import com.example.data.source.GoogleLocationDataSource
import com.example.domain.model.LocationData
import com.example.domain.repository.LocationRepository
import io.reactivex.Flowable
import javax.inject.Inject

class LocationRepositoryImpl  @Inject constructor(
    private val googleLocationDataSource: GoogleLocationDataSource
) : LocationRepository{
    override fun getLocation(): Flowable<LocationData> {
        return googleLocationDataSource
            .locationObservable
            .map { it.mapToDomain() }
    }
}