package com.android.weatherforecastapp.forercast

import com.android.weatherforecastapp.forecast.domain.model.CityModel


object CityTestModelProvider {

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