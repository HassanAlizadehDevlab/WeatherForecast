package com.android.weatherforecastapp.forecast.data.network

import com.android.weatherforecastapp.forecast.data.model.WeatherForeCast
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ForeCastDataService {
    @GET("location/{cityId}/{year}/{month}/{day}/")
    fun getWeatherForeCasts(
        @Path("cityId") cityId: Int,
        @Path("year") year: String,
        @Path("month") month: String,
        @Path("day") day: String,
    ): Single<List<WeatherForeCast>>
}