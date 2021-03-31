package com.example.domain.usecase

import com.example.domain.model.LocationData
import com.example.domain.repository.LocationRepository
import io.reactivex.Flowable
import javax.inject.Inject

class LocationUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {

    fun build() : Flowable<LocationData> {
        return locationRepository.getLocation()
    }

}