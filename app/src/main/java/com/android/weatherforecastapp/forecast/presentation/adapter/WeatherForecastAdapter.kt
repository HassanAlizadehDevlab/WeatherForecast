package com.android.weatherforecastapp.forecast.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.shared.presentation.adapter.BaseRecyclerAdapter
import com.android.shared.presentation.adapter.BaseViewHolder
import com.android.weatherforecastapp.R
import com.android.weatherforecastapp.databinding.AdapterCityBinding
import com.android.weatherforecastapp.forecast.domain.model.CityModel

class WeatherForecastAdapter : BaseRecyclerAdapter<CityModel>() {

    private val FORE_CAST_VIEW: Int = R.layout.adapter_weather_forecast

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CityModel> {
        return CityViewHolder(
            AdapterCityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemViewType(position: Int): Int {
        return FORE_CAST_VIEW
    }

}