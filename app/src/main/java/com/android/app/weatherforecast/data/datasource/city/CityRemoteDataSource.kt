package com.android.app.weatherforecast.data.datasource.city

import com.android.app.weatherforecast.data.model.City
import io.reactivex.Single

interface CityRemoteDataSource {
    fun cityId(name: String): Single<City>
}