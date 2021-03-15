package com.android.weatherforecastapp.forecast

import com.android.weatherforecastapp.forecast.data.DataModule
import com.android.weatherforecastapp.forecast.domain.DomainModule
import com.android.weatherforecastapp.forecast.presentation.PresentationModule
import dagger.Module

@Module(
    includes = [
        DataModule::class,
        DomainModule::class,
        PresentationModule::class,
    ]
)
abstract class MainPageModule