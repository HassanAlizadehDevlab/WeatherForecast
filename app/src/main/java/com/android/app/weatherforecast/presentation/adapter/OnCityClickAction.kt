package com.android.app.weatherforecast.presentation.adapter

import com.android.shared.presentation.adapter.BaseAction
import com.android.app.weatherforecast.domain.model.CityModel

/**
 * Action for cities.
 */
data class OnCityClickAction(val data: CityModel) : BaseAction