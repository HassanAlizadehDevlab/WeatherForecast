package com.android.weatherforecastapp.forecast.data.network

import com.android.weatherforecastapp.forecast.data.model.City
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CityDataService {
    @GET("location/search/")
    fun getCity(@Query(value = "query") cityName: String): Single<City>
}