package com.android.app.weatherforecast.data.mapper

import com.android.app.weatherforecast.data.entity.db.model.CityEntity
import com.android.app.weatherforecast.data.model.City
import com.android.app.weatherforecast.domain.model.CityModel


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