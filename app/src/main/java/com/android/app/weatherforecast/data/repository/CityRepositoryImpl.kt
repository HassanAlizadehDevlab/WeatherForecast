package com.android.app.weatherforecast.data.repository

import com.android.app.weatherforecast.data.datasource.city.CityLocalDataSource
import com.android.app.weatherforecast.data.datasource.city.CityRemoteDataSource
import com.android.app.weatherforecast.data.mapper.map
import com.android.app.weatherforecast.domain.model.CityModel
import com.android.app.weatherforecast.domain.repository.CityRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val remoteDataSource: CityRemoteDataSource,
    private val localDataSource: CityLocalDataSource,
) : CityRepository {

    override fun cities(): Flowable<List<CityModel>> {
        return localDataSource.insertCities()
            .toFlowable<List<CityModel>>()
            .concatWith(localDataSource.cities().map { it.map() })
    }

    override fun cityId(cityName: String): Single<Int> {
        return remoteDataSource.cityId(name = cityName)
            .flatMap { localDataSource.insertCity(it.map()).toSingle { it } }
            .map { it.woeid }
    }
}