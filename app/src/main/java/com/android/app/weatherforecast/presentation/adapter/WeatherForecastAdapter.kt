package com.android.app.weatherforecast.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.shared.presentation.adapter.BaseRecyclerAdapter
import com.android.shared.presentation.adapter.BaseViewHolder
import com.android.app.R
import com.android.app.databinding.AdapterWeatherForecastBinding
import com.android.app.weatherforecast.domain.model.WeatherForeCastModel

class WeatherForecastAdapter : BaseRecyclerAdapter<WeatherForeCastModel>() {

    private val FORE_CAST_VIEW: Int = R.layout.adapter_weather_forecast

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<WeatherForeCastModel> {
        return WeatherForecastViewHolder(
            AdapterWeatherForecastBinding.inflate(
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