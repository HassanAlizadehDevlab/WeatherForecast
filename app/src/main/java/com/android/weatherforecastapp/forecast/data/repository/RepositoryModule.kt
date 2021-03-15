package com.android.weatherforecastapp.forecast.data.repository

import com.android.weatherforecastapp.forecast.domain.repository.CityRepository
import com.android.weatherforecastapp.forecast.domain.repository.ForeCastRepository
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