package com.android.weatherforecastapp.forecast.data.mapper

import com.android.weatherforecastapp.forecast.data.entity.db.model.CityEntity
import com.android.weatherforecastapp.forecast.data.model.City
import com.android.weatherforecastapp.forecast.domain.model.CityModel


fun CityEntity.map(): CityModel = CityModel(
    woeid = woeid,
    title = title,
    locationType = locationType,
    location = location,
)

fun City.map(): CityEntity = CityEntity(
    woeid = woeid,
    title = title,
    locationType = locationType,
    location = location,
)

fun List<CityEntity>.map(): List<CityModel> = map { it.map() }