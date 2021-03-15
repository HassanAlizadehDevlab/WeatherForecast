package com.android.weatherforecastapp.forecast.data.mapper

import com.android.weatherforecastapp.forecast.data.model.WeatherForeCast
import com.android.weatherforecastapp.forecast.domain.model.WeatherForeCastModel


fun WeatherForeCast.map(): WeatherForeCastModel = WeatherForeCastModel(
    id = id,
    weatherStateName = weatherStateName,
    weatherStateAbbr = weatherStateAbbr,
    windDirectionCompass = windDirectionCompass,
    created = created,
    applicableDate = applicableDate,
    minTemp = minTemp,
    maxTemp = maxTemp,
    theTemp = theTemp,
    windSpeed = windSpeed,
    windDirection = windDirection,
    airPressure = airPressure,
    humidity = humidity,
    visibility = visibility,
    predictability = predictability,
)

fun List<WeatherForeCast>.map(): List<WeatherForeCastModel> = map { it.map() }