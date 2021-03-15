package com.android.weatherforecastapp.forecast.presentation.adapter

import com.android.shared.presentation.adapter.BaseAction
import com.android.weatherforecastapp.forecast.domain.model.CityModel

/**
 * Action for cities.
 */
data class OnCityClickAction(val data: CityModel) : BaseAction