package com.android

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
        ApplicationModule::class,
    ]
)
interface ForecastComponent : AndroidInjector<ForecastApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: ForecastApplication): ForecastComponent
    }

}