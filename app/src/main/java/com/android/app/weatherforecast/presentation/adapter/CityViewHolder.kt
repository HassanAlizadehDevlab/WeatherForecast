package com.android.app.weatherforecast.presentation.adapter

import com.android.shared.presentation.adapter.BaseViewHolder
import com.android.app.databinding.AdapterCityBinding
import com.android.app.weatherforecast.domain.model.CityModel

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