package com.android.app.weatherforecast.data.repository

import com.android.app.weatherforecast.domain.repository.CityRepository
import com.android.app.weatherforecast.domain.repository.ForeCastRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideCityRepository(
        cityRepositoryImpl: CityRepositoryImpl
    ): CityRepository

    @Binds
    abstract fun provideWeatherForecastRepository(
        weatherForeCastRepositoryImpl: ForeCastRepositoryImpl
    ): ForeCastRepository

}