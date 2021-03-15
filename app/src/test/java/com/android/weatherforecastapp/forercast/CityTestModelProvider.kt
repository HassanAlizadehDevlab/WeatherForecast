package com.android.weatherforecastapp.forercast

import com.android.weatherforecastapp.forecast.domain.model.CityModel


object CityTestModelProvider {

    fun getGothenburgCityId(): Int {
        return getGothenburg().woeid!!
    }

    fun getGothenburg() = CityModel(
        woeid = 890869,
        title = "Gothenburg",
        locationType = "City",
        location = "57.701328,11.96689",
    )

    fun getCityModels(): List<CityModel> {
        return listOf(
            CityModel(title = "Gothenburg"),
            CityModel(title = "Stockholm"),
            CityModel(title = "Mountain View"),
            CityModel(title = "London"),
            CityModel(title = "New York"),
            CityModel(title = "Berlin"),
        )
    }
}