package com.android.app.weatherforecast

import com.android.app.weatherforecast.data.DataModule
import com.android.app.weatherforecast.domain.DomainModule
import com.android.app.weatherforecast.presentation.PresentationModule
import dagger.Module

@Module(
    includes = [
        DataModule::class,
        DomainModule::class,
        PresentationModule::class,
    ]
)
abstract class WeatherForeCastModule