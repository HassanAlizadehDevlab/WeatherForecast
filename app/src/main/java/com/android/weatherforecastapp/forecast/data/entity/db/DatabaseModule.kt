package com.android.weatherforecastapp.forecast.data.entity.db

import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun cityDao(db: WeatherDatabase) = db.cityDao()

}