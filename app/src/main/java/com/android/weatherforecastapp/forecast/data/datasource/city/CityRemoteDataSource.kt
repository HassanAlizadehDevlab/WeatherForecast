package com.android.weatherforecastapp.forecast.data.datasource.city

import com.android.weatherforecastapp.forecast.data.model.City
import io.reactivex.Single

interface CityRemoteDataSource {
    fun cityId(name: String): Single<City>
}