package com.android.weatherforecastapp.forecast.data.repository

import com.android.weatherforecastapp.forecast.data.datasource.city.CityLocalDataSource
import com.android.weatherforecastapp.forecast.data.datasource.city.CityRemoteDataSource
import com.android.weatherforecastapp.forecast.data.entity.PreferencesHelper
import com.android.weatherforecastapp.forecast.data.mapper.map
import com.android.weatherforecastapp.forecast.domain.model.CityModel
import com.android.weatherforecastapp.forecast.domain.repository.CityRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val remoteDataSource: CityRemoteDataSource,
    private val localDataSource: CityLocalDataSource,
    private val preferences: PreferencesHelper
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