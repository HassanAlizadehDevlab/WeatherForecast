package com.android.app.weatherforecast.domain.repository

import com.android.app.weatherforecast.domain.model.CityModel
import io.reactivex.Flowable
import io.reactivex.Single

interface CityRepository {
    fun cities(): Flowable<List<CityModel>>
    fun cityId(cityName: String): Single<Int>
}