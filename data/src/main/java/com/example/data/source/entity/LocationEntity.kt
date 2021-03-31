package com.example.data.source.entity

import com.example.domain.model.LocationData

data class LocationEntity(
    val latitude: Double,
    val longitude: Double
) {
    fun mapToDomain() : LocationData {
        return LocationData(
            latitude,
            longitude
        )
    }
}