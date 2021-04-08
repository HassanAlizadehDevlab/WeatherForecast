package com.android.app.weatherforecast.domain.model

data class CityModel(
    val woeid: Int? = null,
    val title: String,
    val locationType: String? = null,
    val location: String? = null,
)