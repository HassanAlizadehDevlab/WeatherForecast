package com.android.weatherforecastapp.forecast.data.repository

import com.android.weatherforecastapp.forecast.data.datasource.forecast.ForecastRemoteDataSource
import com.android.weatherforecastapp.forecast.data.mapper.map
import com.android.weatherforecastapp.forecast.domain.model.WeatherForeCastModel
import com.android.weatherforecastapp.forecast.domain.repository.ForeCastRepository
import io.reactivex.Single
import javax.inject.Inject

class ForeCastRepositoryImpl @Inject constructor(
    private val remoteDataSource: ForecastRemoteDataSource
) : ForeCastRepository {

    override fun weatherForeCast(
        cityId: Int,
        year: String,
        month: String,
        day: String,
    ): Single<List<WeatherForeCastModel>> {
        return remoteDataSource.weatherForeCasts(
            cityId = cityId,
            year = year,
            month = month,
            day = day
        ).map { it.map() }
    }
}