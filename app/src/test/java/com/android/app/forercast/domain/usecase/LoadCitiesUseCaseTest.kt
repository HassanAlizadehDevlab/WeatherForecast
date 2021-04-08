package com.android.app.forercast.domain.usecase

import com.android.shared.domain.error.ErrorHandler
import com.android.shared.domain.transformer.TestFTransformer
import com.android.app.weatherforecast.domain.repository.CityRepository
import com.android.app.weatherforecast.domain.usecase.LoadCitiesUseCase
import com.android.app.weatherforecast.domain.usecase.LoadCityResult
import com.android.app.forercast.CityTestModelProvider
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Flowable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoadCitiesUseCaseTest {

    private val repository: CityRepository = mockk()
    private val errorHandler: ErrorHandler = mockk()
    private val usecase = LoadCitiesUseCase(repository, errorHandler, TestFTransformer())


    @Test
    fun `load city list - success`() {
        val response = CityTestModelProvider.getCityModels()
        every { repository.cities() } returns Flowable.just(response)

        usecase.execute(Unit)
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue {
                when (it) {
                    is LoadCityResult.Success -> {
                        it.data.size == response.size
                    }
                    is LoadCityResult.Error -> {
                        false
                    }
                }
            }

        verify { repository.cities() }
    }

    @Test
    fun `load city list - error`() {
        val expectedError = "Unknown Error"
        every { repository.cities() } returns Flowable.error(NullPointerException())
        every { errorHandler.getMessage(any()) } returns expectedError

        usecase.execute(Unit)
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue {
                when (it) {
                    is LoadCityResult.Success -> {
                        false
                    }
                    is LoadCityResult.Error -> {
                        it.error == expectedError
                    }
                }
            }

        verify { repository.cities() }
    }
}