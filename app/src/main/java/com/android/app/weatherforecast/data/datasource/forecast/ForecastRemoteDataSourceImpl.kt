package com.android.app.weatherforecast.data.datasource.forecast

import com.android.app.weatherforecast.data.model.WeatherForeCast
import com.android.app.weatherforecast.data.network.ForeCastDataService
import io.reactivex.Single
import javax.inject.Inject

class ForecastRemoteDataSourceImpl @Inject constructor(
    private val dataService: ForeCastDataService
) : ForecastRemoteDataSource {
    override fun weatherForeCasts(
        cityId: Int,
        year: String,
        month: String,
        day: String,
    ): Single<List<WeatherForeCast>> {
        return dataService.getWeatherForeCasts(
            cityId = cityId, year = year, month = month, day = day
        )
    }
}