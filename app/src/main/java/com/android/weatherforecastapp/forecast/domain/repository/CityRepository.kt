package com.android.weatherforecastapp.forecast.domain.repository

import com.android.weatherforecastapp.forecast.domain.model.CityModel
import io.reactivex.Flowable
import io.reactivex.Single

interface CityRepository {
    fun cities(): Flowable<List<CityModel>>
    fun cityId(cityName: String): Single<Int>
}