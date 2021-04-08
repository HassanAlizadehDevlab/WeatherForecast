package com.android.app.weatherforecast.data.datasource.forecast

import com.android.app.weatherforecast.data.model.WeatherForeCast
import io.reactivex.Single

interface ForecastRemoteDataSource {
    fun weatherForeCasts(
        cityId: Int,
        year: String,
        month: String,
        day: String,
    ): Single<List<WeatherForeCast>>
}