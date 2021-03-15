package com.android.weatherforecastapp.forecast.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.shared.presentation.ViewModelProviderFactory
import com.android.shared.presentation.adapter.BaseAction
import com.android.shared.presentation.recyclerview.HorizontalDecorator
import com.android.shared.presentation.recyclerview.VerticalDecorator
import com.android.weatherforecastapp.R
import com.android.weatherforecastapp.databinding.ActivityMainBinding
import com.android.weatherforecastapp.forecast.domain.model.CityModel
import com.android.weatherforecastapp.forecast.domain.model.WeatherForeCastModel
import com.android.weatherforecastapp.forecast.presentation.adapter.CityAdapter
import com.android.weatherforecastapp.forecast.presentation.adapter.OnCityClickAction
import com.android.weatherforecastapp.forecast.presentation.adapter.WeatherForecastAdapter
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var cityAdapter: CityAdapter
    private lateinit var weatherForecastAdapter: WeatherForecastAdapter

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupRecyclerViews()
        setupObservers()

        viewModel.loadCities()
    }


    private fun setupRecyclerViews() {
        setupWeatherForecastRecyclerView()
        setupCityRecyclerView()
    }

    private fun setupWeatherForecastRecyclerView() {
        weatherForecastAdapter = WeatherForecastAdapter()
        val verticalLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        with(binding.recyclerViewWeatherForeCasts) {
            layoutManager = verticalLayoutManager
            addItemDecoration(
                VerticalDecorator(
                    margin = resources.getDimensionPixelSize(R.dimen.recycler_view_item_margin)
                )
            )
            adapter = weatherForecastAdapter
        }
    }

    private fun setupCityRecyclerView() {
        cityAdapter = CityAdapter(::observeCityClicks)
        val verticalLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        with(binding.recyclerViewCities) {
            layoutManager = verticalLayoutManager
            addItemDecoration(
                HorizontalDecorator(
                    margin = resources.getDimensionPixelSize(R.dimen.recycler_view_item_margin)
                )
            )
            adapter = cityAdapter
        }
    }

    private fun observeCityClicks(action: BaseAction) {
        when (action) {
            is OnCityClickAction -> {
                viewModel.onCityClicked(action.data)
            }
        }
    }

    private fun setupObservers() {
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        viewModel.cityListObservable.observe(this, ::observeCities)
        viewModel.forecastsObservable.observe(this, ::observeWeatherForecasts)
    }

    private fun observeCities(cities: List<CityModel>) {
        cityAdapter.setItems(cities)
    }

    private fun observeWeatherForecasts(forecasts: List<WeatherForeCastModel>) {
        weatherForecastAdapter.setItems(forecasts)
    }

}
