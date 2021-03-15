package com.android.weatherforecastapp.forecast.data.datasource.forecast

import com.android.weatherforecastapp.forecast.data.model.WeatherForeCast
import io.reactivex.Single

interface ForecastRemoteDataSource {
    fun weatherForeCasts(
        cityId: Int,
        year: String,
        month: String,
        day: String,
    ): Single<List<WeatherForeCast>>
}