package com.android.weatherforecastapp.forecast.data.datasource.city

import com.android.weatherforecastapp.forecast.data.model.City
import com.android.weatherforecastapp.forecast.data.network.CityDataService
import io.reactivex.Single
import javax.inject.Inject

class CityRemoteDataSourceImpl @Inject constructor(
    private val service: CityDataService
) : CityRemoteDataSource {

    override fun cityId(name: String): Single<City> {
        return service.getCity(cityName = name)
    }
}