package com.android.weatherforecastapp.forecast.domain

import com.android.shared.domain.usecase.transformer.AsyncFTransformer
import com.android.shared.domain.usecase.transformer.AsyncSTransformer
import com.android.shared.domain.usecase.transformer.FTransformer
import com.android.shared.domain.usecase.transformer.STransformer
import com.android.weatherforecastapp.forecast.domain.usecase.GetCityIdResult
import com.android.weatherforecastapp.forecast.domain.usecase.GetForeCastResult
import com.android.weatherforecastapp.forecast.domain.usecase.LoadCityResult
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetCityTransformer(): STransformer<GetCityIdResult> {
        return AsyncSTransformer()
    }

    @Provides
    fun provideGetCitiesTransformer(): FTransformer<LoadCityResult> {
        return AsyncFTransformer()
    }

    @Provides
    fun provideWeatherForecastTransformer(): STransformer<GetForeCastResult> {
        return AsyncSTransformer()
    }

}