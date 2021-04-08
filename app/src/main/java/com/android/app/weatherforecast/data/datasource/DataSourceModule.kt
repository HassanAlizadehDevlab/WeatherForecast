package com.android.app.weatherforecast.data.datasource

import com.android.app.weatherforecast.data.datasource.city.CityLocalDataSource
import com.android.app.weatherforecast.data.datasource.city.CityLocalDataSourceImpl
import com.android.app.weatherforecast.data.datasource.city.CityRemoteDataSource
import com.android.app.weatherforecast.data.datasource.city.CityRemoteDataSourceImpl
import com.android.app.weatherforecast.data.datasource.forecast.ForecastRemoteDataSource
import com.android.app.weatherforecast.data.datasource.forecast.ForecastRemoteDataSourceImpl
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