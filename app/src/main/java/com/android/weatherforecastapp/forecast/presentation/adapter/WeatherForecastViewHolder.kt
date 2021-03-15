package com.android.weatherforecastapp.forecast.presentation.adapter

import com.android.shared.presentation.adapter.BaseViewHolder
import com.android.weatherforecastapp.databinding.AdapterWeatherForecastBinding
import com.android.weatherforecastapp.forecast.domain.model.WeatherForeCastModel
import com.bumptech.glide.Glide

class WeatherForecastViewHolder(
    private val binding: AdapterWeatherForecastBinding
) : BaseViewHolder<WeatherForeCastModel>(binding.root) {
    override fun bind(data: WeatherForeCastModel) {
        with(binding) {
            // Set data to view
            textViewName.text = data.weatherStateName
            textViewDateTime.text = data.created

            val iconUrl = IMAGE_URL + data.weatherStateAbbr + SUFFIX_PNG
            Glide.with(root)
                .load(iconUrl)
                .into(imageViewForeCast)
        }
    }

    private val IMAGE_URL = "https://www.metaweather.com/static/img/weather/png/64/"
    private val SUFFIX_PNG = ".png"
}

