package com.android.app.weatherforecast.data.model

import com.google.gson.annotations.SerializedName

data class WeatherForeCast(
    @SerializedName("weather_state_name")
    val weatherStateName: String,
    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String,
    @SerializedName("wind_direction_compass")
    val windDirectionCompass: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("applicable_date")
    val applicableDate: String,
    @SerializedName("min_temp")
    val minTemp: String?,
    @SerializedName("max_temp")
    val maxTemp: String?,
    @SerializedName("the_temp")
    val theTemp: String?,
    @SerializedName("wind_speed")
    val windSpeed: Float?,
    @SerializedName("wind_direction")
    val windDirection: Double?,
    @SerializedName("air_pressure")
    val airPressure: String?,
    @SerializedName("humidity")
    val humidity: Int?,
    @SerializedName("visibility")
    val visibility: Double?,
    @SerializedName("predictability")
    val predictability: Int?
)