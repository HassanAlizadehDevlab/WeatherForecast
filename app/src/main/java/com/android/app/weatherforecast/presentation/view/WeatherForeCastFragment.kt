package com.android.app.weatherforecast.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.app.R
import com.android.app.databinding.FragmentWeatherForecastBinding
import com.android.app.weatherforecast.domain.model.CityModel
import com.android.app.weatherforecast.domain.model.WeatherForeCastModel
import com.android.app.weatherforecast.presentation.adapter.CityAdapter
import com.android.app.weatherforecast.presentation.adapter.OnCityClickAction
import com.android.app.weatherforecast.presentation.adapter.WeatherForecastAdapter
import com.android.shared.presentation.ViewModelProviderFactory
import com.android.shared.presentation.adapter.BaseAction
import com.android.shared.presentation.recyclerview.HorizontalDecorator
import com.android.shared.presentation.recyclerview.VerticalDecorator
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class WeatherForeCastFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: WeatherForecastViewModel

    private lateinit var cityAdapter: CityAdapter
    private lateinit var weatherForecastAdapter: WeatherForecastAdapter

    private var _binding: FragmentWeatherForecastBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        viewModel.loadCities()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherForecastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        setupObservers()
    }


    private fun setupRecyclerViews() {
        setupWeatherForecastRecyclerView()
        setupCityRecyclerView()
    }

    private fun setupWeatherForecastRecyclerView() {
        weatherForecastAdapter = WeatherForecastAdapter()
        val verticalLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

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
        val verticalLayoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

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

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, factory)[WeatherForecastViewModel::class.java]
    }

    private fun setupObservers() {

        viewModel.messageObservable.observe(viewLifecycleOwner, ::observeMessage)
        viewModel.isLoadingObservable.observe(viewLifecycleOwner, ::observeLoading)
        viewModel.cityListObservable.observe(viewLifecycleOwner, ::observeCities)
        viewModel.forecastsObservable.observe(viewLifecycleOwner, ::observeWeatherForecasts)
        viewModel.selectedCityTitle.observe(viewLifecycleOwner, ::observeCityTitle)
    }

    private fun observeMessage(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    private fun observeLoading(isLoading: Boolean) {
        if (isLoading)
            binding.progress.show()
        else
            binding.progress.hide()
    }

    private fun observeCities(cities: List<CityModel>) {
        cityAdapter.setItems(cities)
    }

    private fun observeWeatherForecasts(forecasts: List<WeatherForeCastModel>) {
        binding.recyclerViewWeatherForeCasts.visibility = View.VISIBLE
        weatherForecastAdapter.setItems(forecasts)
    }

    private fun observeCityTitle(title: String) {
        // Here we can use SharedViewModel or Use an interface that the activity should implement it.
        // And in onAttach function get the activity object and cast it to this interface then use it.
        // I preferred to use this for simplicity.
        (activity as AppCompatActivity).supportActionBar?.title = title
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): WeatherForeCastFragment = WeatherForeCastFragment()
    }

}