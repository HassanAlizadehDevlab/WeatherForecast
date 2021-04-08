package com.android.app.weatherforecast.data.datasource

import com.android.app.weatherforecast.data.datasource.city.CityLocalDataSource
import com.android.app.weatherforecast.data.datasource.city.CityLocalDataSourceImpl
import com.android.app.weatherforecast.data.datasource.city.CityRemoteDataSource
import com.android.app.weatherforecast.data.datasource.city.CityRemoteDataSourceImpl
import com.android.app.weatherforecast.data.datasource.forecast.ForecastRemoteDataSource
import com.android.app.weatherforecast.data.datasource.forecast.ForecastRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun provideRemoteCityDataSource(
        remoteCityDataSourceImpl: CityRemoteDataSourceImpl
    ): CityRemoteDataSource


    @Binds
    abstract fun provideLocalCityDataSource(
        localCityDataSourceImpl: CityLocalDataSourceImpl
    ): CityLocalDataSource


    @Binds
    abstract fun provideRemoteWeatherForecastDataSource(
        remoteForecastDataSourceImpl: ForecastRemoteDataSourceImpl
    ): ForecastRemoteDataSource

}