package com.android.app.weatherforecast.data.datasource.city

import com.android.app.weatherforecast.data.entity.db.model.CityEntity
import io.reactivex.Completable
import io.reactivex.Flowable

interface CityLocalDataSource {
    fun cities(): Flowable<List<CityEntity>>
    fun insertCity(city: CityEntity): Completable
    fun insertCities(): Completable
}