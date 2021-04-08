package com.android.app.weatherforecast.domain.repository

import com.android.app.weatherforecast.domain.model.WeatherForeCastModel
import io.reactivex.Single

interface ForeCastRepository {
    fun weatherForeCast(
        cityId: Int,
        year: String,
        month: String,
        day: String,
    ): Single<List<WeatherForeCastModel>>
}