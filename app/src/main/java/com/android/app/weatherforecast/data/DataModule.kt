package com.android.app.weatherforecast.data

import com.android.app.weatherforecast.data.datasource.DataSourceModule
import com.android.app.weatherforecast.data.entity.EntityModule
import com.android.app.weatherforecast.data.network.NetworkModule
import com.android.app.weatherforecast.data.repository.RepositoryModule
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