package com.android.weatherforecastapp.forecast.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.android.shared.presentation.BaseViewModel
import com.android.weatherforecastapp.forecast.domain.model.CityModel
import com.android.weatherforecastapp.forecast.domain.model.WeatherForeCastModel
import com.android.weatherforecastapp.forecast.domain.usecase.*
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val loadCitiesUseCase: LoadCitiesUseCase,
    private val getCityIdUseCase: GetCityIdUseCase,
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase,
) : BaseViewModel() {


    /****************************** Observables ******************************/
    private val _citiesObservable = MutableLiveData<List<CityModel>>()
    val cityListObservable: LiveData<List<CityModel>> =
        Transformations.map(_citiesObservable) { it }
    private val _forecastsObservable = MutableLiveData<List<WeatherForeCastModel>>()
    val forecastsObservable: LiveData<List<WeatherForeCastModel>> =
        Transformations.map(_forecastsObservable) { it }


    /****************************** Requests ******************************/
    fun loadCities() {
        loadCitiesUseCase.execute(Unit)
            .subscribe({
                onCitiesResponse(it)
            }, {})
            .track()
    }

    private fun getCityId(name: String) {
        getCityIdUseCase.execute(GetCityIdRequest(cityName = name))
            .subscribe({
                onCityIdResponse(it)
            }, {})
            .track()
    }

    private fun getWeatherForeCasts(id: Int) {
        getWeatherForecastUseCase.execute(GetForeCastRequest(cityId = id))
            .subscribe({
                onWeatherForeCastsResponse(it)
            }, {
                print(it.message)
            })
            .track()
    }


    /****************************** Responses ******************************/
    private fun onCitiesResponse(response: LoadCityResult) {
        when (response) {
            is LoadCityResult.Success -> {
                _citiesObservable.value = response.data
            }
            is LoadCityResult.Error -> {
                response.error?.let {
                    _messageObservable.value = it
                }
            }
        }
    }

    private fun onCityIdResponse(response: GetCityIdResult) {
        when (response) {
            is GetCityIdResult.Success -> {
                getWeatherForeCasts(response.cityId)
            }
            is GetCityIdResult.Error -> {
                response.error?.let {
                    _messageObservable.value = it
                }
            }
        }
    }

    private fun onWeatherForeCastsResponse(response: GetForeCastResult) {
        when (response) {
            is GetForeCastResult.Success -> {
                _forecastsObservable.value = response.weatherForecasts
            }
            is GetForeCastResult.Error -> {
                response.error?.let {
                    _messageObservable.value = it
                }
            }
        }
    }


    /****************************** Clicks ******************************/
    fun onCityClicked(city: CityModel) {
        if (city.woeid == null)
            getCityId(city.title)
        else
            getWeatherForeCasts(city.woeid)
    }

}