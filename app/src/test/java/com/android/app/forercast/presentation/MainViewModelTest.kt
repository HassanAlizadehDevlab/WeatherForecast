package com.android.app.forercast.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.shared.utils.observeOnce
import com.android.app.weatherforecast.domain.model.CityModel
import com.android.app.weatherforecast.domain.model.WeatherForeCastModel
import com.android.app.weatherforecast.domain.usecase.*
import com.android.app.weatherforecast.presentation.view.MainViewModel
import com.android.app.forercast.CityTestModelProvider
import com.android.app.forercast.ForeCastTestModelProvider
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val loadCitiesUseCase: LoadCitiesUseCase = mockk()
    private val getCityIdUseCase: GetCityIdUseCase = mockk()
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase = mockk()
    private val viewModel = MainViewModel(
        loadCitiesUseCase,
        getCityIdUseCase,
        getWeatherForecastUseCase
    )

    @Test
    fun `get saved cities - success`() {
        val responseObserver: (List<CityModel>) -> Unit = mockk()
        viewModel.cityListObservable.observeOnce(responseObserver)
        val response = LoadCityResult.Success(CityTestModelProvider.getCityModels())
        every { loadCitiesUseCase.execute(Unit) } returns Flowable.just(response)
        every { responseObserver.invoke(any()) } returns Unit

        viewModel.loadCities()

        verify { loadCitiesUseCase.execute(Unit) }
        verify { responseObserver.invoke(response.data) }
    }

    @Test
    fun `when city has no id, call to get it then get weather forecasts - success`() {
        val city = CityTestModelProvider.getCityModels()[0]
        val cityRequest = GetCityIdRequest(cityName = city.title)
        val cityResponse = CityTestModelProvider.getGothenburg().woeid!!
        val cityResult = GetCityIdResult.Success(cityId = cityResponse)

        val forecastsRequest = GetForeCastRequest(cityId = cityResult.cityId)
        val forecastsResponse = ForeCastTestModelProvider.weatherForeCastModelList()
        val forecastsResult = GetForeCastResult.Success(weatherForecasts = forecastsResponse)

        every { getCityIdUseCase.execute(cityRequest) } returns Single.just(cityResult)
        every { getWeatherForecastUseCase.execute(forecastsRequest) } returns Single.just(forecastsResult)

        viewModel.onCityClicked(city)

        verify { getCityIdUseCase.execute(cityRequest) }
        verify { getWeatherForecastUseCase.execute(forecastsRequest) }
    }

    @Test
    fun `when city has id, call to get it then get weather forecasts and don't call get city id usecase - success`() {
        val city = CityTestModelProvider.getGothenburg()
        val cityRequest = GetCityIdRequest(cityName = city.title)
        val cityResponse = CityTestModelProvider.getGothenburg().woeid!!
        val cityResult = GetCityIdResult.Success(cityId = cityResponse)

        val forecastsRequest = GetForeCastRequest(cityId = cityResult.cityId)
        val forecastsResponse = ForeCastTestModelProvider.weatherForeCastModelList()
        val forecastsResult = GetForeCastResult.Success(weatherForecasts = forecastsResponse)

        every { getWeatherForecastUseCase.execute(forecastsRequest) } returns Single.just(forecastsResult)

        viewModel.onCityClicked(city)

        verify(exactly = 0) { getCityIdUseCase.execute(cityRequest) }
        verify { getWeatherForecastUseCase.execute(forecastsRequest) }
    }

    @Test
    fun `get weather forecasts and set them in liveData - success`() {
        val city = CityTestModelProvider.getCityModels()[0]
        val cityRequest = GetCityIdRequest(cityName = city.title)
        val cityResponse = CityTestModelProvider.getGothenburg().woeid!!
        val cityResult = GetCityIdResult.Success(cityId = cityResponse)

        val forecastsRequest = GetForeCastRequest(cityId = cityResult.cityId)
        val forecastsResponse = ForeCastTestModelProvider.weatherForeCastModelList()
        val forecastsResult = GetForeCastResult.Success(weatherForecasts = forecastsResponse)

        val forecastsObserver: (List<WeatherForeCastModel>) -> Unit = mockk()
        viewModel.forecastsObservable.observeOnce(forecastsObserver)

        every { getCityIdUseCase.execute(cityRequest) } returns Single.just(cityResult)
        every { getWeatherForecastUseCase.execute(forecastsRequest) } returns Single.just(forecastsResult)
        every { forecastsObserver.invoke(any()) } returns Unit

        viewModel.onCityClicked(city)

        verify { forecastsObserver.invoke(forecastsResponse) }
    }

    @Test
    fun `select city then fill live data to show the selected city name in view - success`() {
        val city = CityTestModelProvider.getCityModels()[0]
        val cityRequest = GetCityIdRequest(cityName = city.title)
        val cityResponse = CityTestModelProvider.getGothenburg().woeid!!
        val cityResult = GetCityIdResult.Success(cityId = cityResponse)

        val forecastsRequest = GetForeCastRequest(cityId = cityResult.cityId)
        val forecastsResponse = ForeCastTestModelProvider.weatherForeCastModelList()
        val forecastsResult = GetForeCastResult.Success(weatherForecasts = forecastsResponse)

        val selectedCityTitleObserver: (String) -> Unit = mockk()
        viewModel.selectedCityTitle.observeOnce(selectedCityTitleObserver)

        every { getCityIdUseCase.execute(cityRequest) } returns Single.just(cityResult)
        every { getWeatherForecastUseCase.execute(forecastsRequest) } returns Single.just(forecastsResult)
        every { selectedCityTitleObserver.invoke(any()) } returns Unit

        viewModel.onCityClicked(city)

        verify { selectedCityTitleObserver.invoke(city.title) }
    }

}