package com.android.weatherforecastapp.forercast.domain.usecase

import com.android.shared.domain.error.ErrorHandler
import com.android.shared.domain.transformer.TestSTransformer
import com.android.weatherforecastapp.forecast.domain.repository.ForeCastRepository
import com.android.weatherforecastapp.forecast.domain.usecase.GetForeCastRequest
import com.android.weatherforecastapp.forecast.domain.usecase.GetForeCastResult
import com.android.weatherforecastapp.forecast.domain.usecase.GetWeatherForecastUseCase
import com.android.weatherforecastapp.forercast.ForeCastTestModelProvider
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class GetWeatherForecastUseCaseTest {

    private val repository: ForeCastRepository = mockk()
    private val errorHandler: ErrorHandler = mockk()
    private val usecase = GetWeatherForecastUseCase(repository, errorHandler, TestSTransformer())


    @Test
    fun `get weather forecasts for Gothenburg by city id - success`() {
        val cityId = 890869
        val tomorrow = GregorianCalendar()
        tomorrow.add(Calendar.DATE, 1)
        val year = tomorrow.get(Calendar.YEAR).toString()
        val month = tomorrow.get(Calendar.MONTH).plus(1).toString()
        val day = tomorrow.get(Calendar.DATE).toString()
        val response = ForeCastTestModelProvider.weatherForeCastModelList()
        val request = GetForeCastRequest(cityId)
        val expectedError = "Unknown Error"
        every { repository.weatherForeCast(request.cityId, year, month, day) } returns Single.just(response)
        every { errorHandler.getMessage(any()) } returns expectedError

        usecase.execute(request)
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue {
                when (it) {
                    is GetForeCastResult.Success -> {
                        it.weatherForecasts.size == response.size
                    }
                    is GetForeCastResult.Error -> {
                        false
                    }
                }
            }

        verify { repository.weatherForeCast(request.cityId, year, month, day) }
    }


    @Test
    fun `check list is reversed`() {
        val cityId = 890869
        val tomorrow = GregorianCalendar()
        tomorrow.add(Calendar.DATE, 1)
        val year = tomorrow.get(Calendar.YEAR).toString()
        val month = tomorrow.get(Calendar.MONTH).plus(1).toString()
        val day = tomorrow.get(Calendar.DATE).toString()
        val response = ForeCastTestModelProvider.weatherForeCastModelList()
        val request = GetForeCastRequest(cityId)
        val expectedError = "Unknown Error"
        every { repository.weatherForeCast(request.cityId, year, month, day) } returns Single.just(response)
        every { errorHandler.getMessage(any()) } returns expectedError

        usecase.execute(request)
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue {
                when (it) {
                    is GetForeCastResult.Success -> {
                        it.weatherForecasts == response.asReversed()
                    }
                    is GetForeCastResult.Error -> {
                        false
                    }
                }
            }
    }

}