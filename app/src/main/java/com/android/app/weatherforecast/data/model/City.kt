package com.android.app.weatherforecast.data.model

data class City(
    val woeid: Int,
    val title: String,
    val locationType: String,
    val location: String,
)