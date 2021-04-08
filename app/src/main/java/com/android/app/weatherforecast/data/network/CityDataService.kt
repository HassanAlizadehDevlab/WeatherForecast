package com.android.app.weatherforecast.data.network

import com.android.app.weatherforecast.data.model.City
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CityDataService {
    @GET("location/search/")
    fun getCity(@Query(value = "query") cityName: String): Single<List<City>>
}