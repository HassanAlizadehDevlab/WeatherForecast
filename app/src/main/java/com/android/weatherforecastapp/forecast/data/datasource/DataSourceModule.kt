package com.android.weatherforecastapp.forecast.data.datasource

import com.android.weatherforecastapp.forecast.data.datasource.city.CityLocalDataSource
import com.android.weatherforecastapp.forecast.data.datasource.city.CityLocalDataSourceImpl
import com.android.weatherforecastapp.forecast.data.datasource.city.CityRemoteDataSource
import com.android.weatherforecastapp.forecast.data.datasource.city.CityRemoteDataSourceImpl
import com.android.weatherforecastapp.forecast.data.datasource.forecast.ForecastRemoteDataSource
import com.android.weatherforecastapp.forecast.data.datasource.forecast.ForecastRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class DataSourceModule {

    @Binds
    @Reusable
    abstract fun provideRemoteCityDataSource(
        remoteCityDataSourceImpl: CityRemoteDataSourceImpl
    ): CityRemoteDataSource


    @Binds
    @Reusable
    abstract fun provideLocalCityDataSource(
        localCityDataSourceImpl: CityLocalDataSourceImpl
    ): CityLocalDataSource


    @Binds
    @Reusable
    abstract fun provideRemoteWeatherForecastDataSource(
        remoteForecastDataSourceImpl: ForecastRemoteDataSourceImpl
    ): ForecastRemoteDataSource

}