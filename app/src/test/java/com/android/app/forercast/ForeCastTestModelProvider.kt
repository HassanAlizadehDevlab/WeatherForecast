package com.android.app.forercast

import com.android.shared.utils.TestUtil
import com.android.app.weatherforecast.data.mapper.map
import com.android.app.weatherforecast.data.model.WeatherForeCast
import com.android.app.weatherforecast.domain.model.WeatherForeCastModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ForeCastTestModelProvider {

    fun weatherForeCastModelList(): List<WeatherForeCastModel> {
        return weatherForeCastList().map()
    }

    private fun weatherForeCastList(): List<WeatherForeCast> {
        val typeToken = object : TypeToken<List<WeatherForeCast>>() {}.type

        return with(TestUtil.parseJson("weather_forcast.json")) {
            Gson().fromJson(this, typeToken)
        }
    }
}