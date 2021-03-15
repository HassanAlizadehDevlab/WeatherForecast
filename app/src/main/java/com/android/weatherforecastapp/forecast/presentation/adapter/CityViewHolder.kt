package com.android.weatherforecastapp.forecast.presentation.adapter

import com.android.shared.presentation.adapter.BaseViewHolder
import com.android.weatherforecastapp.databinding.AdapterCityBinding
import com.android.weatherforecastapp.forecast.domain.model.CityModel

class CityViewHolder(
    private val binding: AdapterCityBinding
) : BaseViewHolder<CityModel>(binding.root) {
    override fun bind(data: CityModel) {
        with(binding) {
            // Set data to view
            textViewCity.text = data.title

            // Set click listeners
            root.setOnClickListener {
                listener.invoke(OnCityClickAction(data))
            }
        }
    }
}