package com.android.weatherforecastapp

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Project dagger component.
 */
@Singleton
@Component(
    modules = [
        WeatherForecastModule::class,
    ]
)
interface ForecastComponent : AndroidInjector<ForecastApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: ForecastApplication): ForecastComponent
    }

}