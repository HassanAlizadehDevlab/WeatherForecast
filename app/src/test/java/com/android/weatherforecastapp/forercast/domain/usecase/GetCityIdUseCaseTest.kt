package com.android.weatherforecastapp.forercast.domain.usecase

import com.android.shared.domain.error.ErrorHandler
import com.android.shared.domain.transformer.TestSTransformer
import com.android.weatherforecastapp.forecast.domain.repository.CityRepository
import com.android.weatherforecastapp.forecast.domain.usecase.GetCityIdRequest
import com.android.weatherforecastapp.forecast.domain.usecase.GetCityIdResult
import com.android.weatherforecastapp.forecast.domain.usecase.GetCityIdUseCase
import com.android.weatherforecastapp.forercast.CityTestModelProvider
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetCityIdUseCaseTest {

    private val repository: CityRepository = mockk()
    private val errorHandler: ErrorHandler = mockk()
    private val usecase = GetCityIdUseCase(repository, errorHandler, TestSTransformer())

    @Test
    fun `get city id by name of city - success`() {
        val cityName = "Gothenburg"
        val request = GetCityIdRequest(cityName)
        val response = CityTestModelProvider.getGothenburgCityId()
        every { repository.cityId(request.cityName) } returns Single.just(response)

        usecase.execute(request)
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue {
                when (it) {
                    is GetCityIdResult.Success -> {
                        it.cityId == response
                    }
                    is GetCityIdResult.Error -> {
                        false
                    }
                }
            }

        verify { repository.cityId(request.cityName) }
    }

    @Test
    fun `get city id by name of city - error`() {
        val cityName = "Gothenburg"
        val request = GetCityIdRequest(cityName)
        val expectedError = "Unknown Error"
        every { repository.cityId(request.cityName) } returns Single.error(NullPointerException())
        every { errorHandler.getMessage(any()) } returns expectedError

        usecase.execute(request)
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue {
                when (it) {
                    is GetCityIdResult.Success -> {
                        false
                    }
                    is GetCityIdResult.Error -> {
                        it.error == expectedError
                    }
                }
            }

        verify { repository.cityId(request.cityName) }
    }

}