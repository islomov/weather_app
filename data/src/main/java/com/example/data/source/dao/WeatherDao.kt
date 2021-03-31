package com.example.data.source.dao

import androidx.room.*
import com.example.data.source.entity.WeatherEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data: WeatherEntity): Completable

    @Query("SELECT * from weather")
    fun queryData(): Maybe<WeatherEntity>


}