package com.android.weatherforecastapp

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.android.shared.SharedModule
import com.android.shared.data.entity.PreferencesHelper
import com.android.shared.data.entity.PreferencesHelperImpl
import com.android.shared.di.scope.ActivityScope
import com.android.weatherforecastapp.forecast.MainPageModule
import com.android.weatherforecastapp.forecast.data.entity.db.WeatherDatabase
import com.android.weatherforecastapp.forecast.presentation.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module(
    includes = [
        AndroidInjectionModule::class,
        WeatherForecastModule.BaseModule::class,
        SharedModule::class,
    ]
)
abstract class WeatherForecastModule {

    /****************** Activities ******************/
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainPageModule::class])
    abstract fun mainActivityInjector(): MainActivity


    /****************** Basic dependencies ******************/
    @Binds
    @Singleton
    abstract fun application(application: ForecastApplication): Application


    @Binds
    @Reusable
    abstract fun providePreferencesHelper(
        preferencesHelperImpl: PreferencesHelperImpl
    ): PreferencesHelper


    @Module
    object BaseModule {

        @Provides
        @Singleton
        fun database(application: Application): WeatherDatabase = Room.databaseBuilder(
            application.applicationContext,
            WeatherDatabase::class.java,
            "weather_forecast_db"
        ).build()

        @Provides
        @Reusable
        fun provideSharedPreferences(
            context: Context
        ): SharedPreferences {
            return context.getSharedPreferences("ForecastApplication", Activity.MODE_PRIVATE)
        }
    }

}