package com.android.weatherforecastapp.forecast.domain.repository

import com.android.weatherforecastapp.forecast.domain.model.WeatherForeCastModel
import io.reactivex.Single

interface ForeCastRepository {
    fun weatherForeCast(
        cityId: Int,
        year: String,
        month: String,
        day: String,
    ): Single<List<WeatherForeCastModel>>
}