package com.example.domain.repository

import com.example.domain.model.LocationData
import io.reactivex.Flowable

interface LocationRepository {

    fun getLocation(): Flowable<LocationData>

}