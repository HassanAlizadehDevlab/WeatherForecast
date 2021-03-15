package com.android.weatherforecastapp.forecast.domain.repository

import com.android.weatherforecastapp.forecast.domain.model.CityModel
import io.reactivex.Flowable

interface CityRepository {
    fun cities(): Flowable<List<CityModel>>
}