package com.android.app.weatherforecast.data.mapper

import com.android.app.weatherforecast.data.model.WeatherForeCast
import com.android.app.weatherforecast.domain.model.WeatherForeCastModel


fun WeatherForeCast.map(): WeatherForeCastModel = WeatherForeCastModel(
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