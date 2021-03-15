package com.android.weatherforecastapp.forecast.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.shared.presentation.adapter.BaseAction
import com.android.shared.presentation.adapter.BaseRecyclerAdapter
import com.android.shared.presentation.adapter.BaseViewHolder
import com.android.weatherforecastapp.R
import com.android.weatherforecastapp.databinding.AdapterCityBinding
import com.android.weatherforecastapp.forecast.domain.model.CityModel

class CityAdapter(
    private val listener: (BaseAction) -> Unit
) : BaseRecyclerAdapter<CityModel>() {

    private val CITY_VIEW: Int = R.layout.adapter_city

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CityModel> {
        val holder = CityViewHolder(
            AdapterCityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        holder.listener = listener
        return holder
    }

    override fun getItemViewType(position: Int): Int {
        return CITY_VIEW
    }

}