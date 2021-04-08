package com.android.app.weatherforecast.data.repository

import com.android.app.weatherforecast.domain.repository.CityRepository
import com.android.app.weatherforecast.domain.repository.ForeCastRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class RepositoryModule {

    @Binds
    @Reusable
    abstract fun provideCityRepository(
        cityRepositoryImpl: CityRepositoryImpl
    ): CityRepository

    @Binds
    @Reusable
    abstract fun provideWeatherForecastRepository(
        weatherForeCastRepositoryImpl: ForeCastRepositoryImpl
    ): ForeCastRepository

}