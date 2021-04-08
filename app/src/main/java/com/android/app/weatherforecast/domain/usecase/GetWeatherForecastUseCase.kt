package com.android.app.weatherforecast.domain.usecase

import com.android.shared.domain.error.ErrorHandler
import com.android.shared.domain.usecase.AsyncUseCase
import com.android.shared.domain.usecase.transformer.STransformer
import com.android.app.weatherforecast.domain.model.WeatherForeCastModel
import com.android.app.weatherforecast.domain.repository.ForeCastRepository
import io.reactivex.Single
import java.util.*
import javax.inject.Inject


class GetWeatherForecastUseCase @Inject constructor(
    private val repository: ForeCastRepository,
    private val errorHandler: ErrorHandler,
    private val transformer: STransformer<GetForeCastResult>,
) : AsyncUseCase<GetForeCastRequest, Single<GetForeCastResult>> {

    override fun execute(param: GetForeCastRequest): Single<GetForeCastResult> {
        return getTomorrow()
            .flatMap { tomorrow ->
                repository.weatherForeCast(
                    cityId = param.cityId,
                    year = tomorrow.get(Calendar.YEAR).toString(),
                    month = tomorrow.get(Calendar.MONTH).plus(1).toString(),
                    day = tomorrow.get(Calendar.DATE).toString(),
                )
            }
            .toFlowable()
            .concatMap { reverseTheList(it).toFlowable() }
            .concatMap { prepareResult(it).toFlowable() }
            .single(GetForeCastResult.Error(errorHandler.getMessage(null)))
            .onErrorReturn { GetForeCastResult.Error(errorHandler.getMessage(it))}
            .compose(transformer)
    }

    private fun getTomorrow(): Single<GregorianCalendar> {
        return Single.just(GregorianCalendar())
            .map {
                it.add(Calendar.DATE, 1)
                it
            }
    }

    private fun reverseTheList(list: List<WeatherForeCastModel>): Single<List<WeatherForeCastModel>> {
        return Single.just(list).map { it.asReversed() }
    }

    private fun prepareResult(list: List<WeatherForeCastModel>): Single<GetForeCastResult> {
        return Single.just(list).map {
            GetForeCastResult.Success(it)
        }
    }

}

data class GetForeCastRequest(
    val cityId: Int,
)


sealed class GetForeCastResult {
    data class Success(val weatherForecasts: List<WeatherForeCastModel>) : GetForeCastResult()
    data class Error(val error: String?) : GetForeCastResult()
}