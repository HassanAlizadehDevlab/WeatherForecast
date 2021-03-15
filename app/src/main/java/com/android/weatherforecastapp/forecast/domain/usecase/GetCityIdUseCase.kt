package com.android.weatherforecastapp.forecast.domain.usecase

import com.android.shared.domain.string.ErrorHandler
import com.android.shared.domain.usecase.AsyncUseCase
import com.android.shared.domain.usecase.transformer.STransformer
import com.android.weatherforecastapp.forecast.domain.repository.CityRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCityIdUseCase @Inject constructor(
    private val repository: CityRepository,
    private val errorHandler: ErrorHandler,
    private val transformer: STransformer<GetCityIdResult>,
) : AsyncUseCase<GetCityIdRequest, Single<GetCityIdResult>> {

    override fun execute(param: GetCityIdRequest): Single<GetCityIdResult> {
        return repository.cityId(cityName = param.cityName)
            .map<GetCityIdResult> { id -> GetCityIdResult.Success(id) }
            .onErrorReturn { GetCityIdResult.Error(errorHandler.getMessage(it)) }
            .compose(transformer)
    }

}


data class GetCityIdRequest(
    val cityName: String,
)


sealed class GetCityIdResult {
    data class Success(val cityId: Int) : GetCityIdResult()
    data class Error(val error: String?) : GetCityIdResult()
}