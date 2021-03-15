package com.android.weatherforecastapp.forecast.domain.model

data class WeatherForeCastModel(
    val id: Int,
    val weatherStateName: String,
    val weatherStateAbbr: String,
    val windDirectionCompass: String,
    val created: String,
    val applicableDate: String,
    val minTemp: String?,
    val maxTemp: String?,
    val theTemp: String?,
    val windSpeed: Float?,
    val windDirection: Double?,
    val airPressure: String?,
    val humidity: Int?,
    val visibility: Double?,
    val predictability: Int?
)