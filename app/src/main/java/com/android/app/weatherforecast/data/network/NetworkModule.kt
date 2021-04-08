package com.android.app.weatherforecast.data.network

import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class NetworkModule {

    @Provides
    @Reusable
    fun provideCityDataService(): CityDataService {
        return DataServiceFactory.create(CityDataService::class.java)
    }

    @Provides
    @Reusable
    fun provideForeCastDataService(): ForeCastDataService {
        return DataServiceFactory.create(ForeCastDataService::class.java)
    }

}