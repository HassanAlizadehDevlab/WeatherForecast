package com.android.weatherforecastapp.forecast.domain.usecase

import com.android.shared.domain.error.ErrorHandler
import com.android.shared.domain.usecase.AsyncUseCase
import com.android.shared.domain.usecase.transformer.FTransformer
import com.android.weatherforecastapp.forecast.domain.model.CityModel
import com.android.weatherforecastapp.forecast.domain.repository.CityRepository
import io.reactivex.Flowable
import javax.inject.Inject

class LoadCitiesUseCase @Inject constructor(
    private val repository: CityRepository,
    private val errorHandler: ErrorHandler,
    private val transformer: FTransformer<LoadCityResult>,
) : AsyncUseCase<Unit, Flowable<LoadCityResult>> {

    override fun execute(param: Unit): Flowable<LoadCityResult> {
        return repository.cities()
            .map<LoadCityResult> {
                LoadCityResult.Success(it)
            }.onErrorReturn {
                LoadCityResult.Error(errorHandler.getMessage(it))
            }.compose(transformer)
    }
}


sealed class LoadCityResult {
    data class Success(val data: List<CityModel>) : LoadCityResult()
    data class Error(val error: String?) : LoadCityResult()
}