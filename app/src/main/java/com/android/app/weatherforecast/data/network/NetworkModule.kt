package com.android.app.weatherforecast.data.network

import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideCityDataService(): CityDataService {
        return DataServiceFactory.create(CityDataService::class.java)
    }

    @Provides
    fun provideForeCastDataService(): ForeCastDataService {
        return DataServiceFactory.create(ForeCastDataService::class.java)
    }

}