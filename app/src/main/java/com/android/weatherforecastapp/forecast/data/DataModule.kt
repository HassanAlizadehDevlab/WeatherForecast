package com.android.weatherforecastapp.forecast.data

import com.android.weatherforecastapp.forecast.data.datasource.DataSourceModule
import com.android.weatherforecastapp.forecast.data.entity.EntityModule
import com.android.weatherforecastapp.forecast.data.network.NetworkModule
import com.android.weatherforecastapp.forecast.data.repository.RepositoryModule
import dagger.Module

@Module(
    includes = [
        DataSourceModule::class,
        EntityModule::class,
        NetworkModule::class,
        RepositoryModule::class,
    ]
)
class DataModule