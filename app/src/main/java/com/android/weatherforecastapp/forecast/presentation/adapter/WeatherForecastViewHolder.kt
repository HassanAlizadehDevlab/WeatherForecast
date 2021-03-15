package com.android.weatherforecastapp.forecast.presentation.adapter

import com.android.shared.presentation.adapter.BaseViewHolder
import com.android.shared.utils.DateUtils
import com.android.weatherforecastapp.databinding.AdapterWeatherForecastBinding
import com.android.weatherforecastapp.forecast.domain.model.WeatherForeCastModel
import com.bumptech.glide.Glide
import java.text.ParseException

class WeatherForecastViewHolder(
    private val binding: AdapterWeatherForecastBinding
) : BaseViewHolder<WeatherForeCastModel>(binding.root) {
    override fun bind(data: WeatherForeCastModel) {
        with(binding) {

            // Set data to view
            textViewName.text = data.weatherStateName

            // Set time
            textViewDateTime.text = try {
                DateUtils.formatDateFromDateString(
                    inputDateFormat = DateUtils.DATE_FORMAT_12,
                    outputDateFormat = DateUtils.DATE_FORMAT_2,
                    inputDate = data.created
                )
            } catch (e: ParseException) {
                "---"
            }

            // Set image
            val urlBuilder = StringBuilder()
            urlBuilder.append(IMAGE_URL)
            urlBuilder.append(data.weatherStateAbbr)
            urlBuilder.append(SUFFIX_PNG)

            Glide.with(root)
                .load(urlBuilder.toString())
                .into(imageViewForeCast)
        }
    }

    private val IMAGE_URL = "https://www.metaweather.com/static/img/weather/png/64/"
    private val SUFFIX_PNG = ".png"
}


