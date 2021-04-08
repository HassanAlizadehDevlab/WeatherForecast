package com.android

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.android.app.MainActivity
import com.android.app.MainActivityModule
import com.android.app.weatherforecast.data.entity.db.WeatherDatabase
import com.android.shared.SharedModule
import com.android.shared.data.entity.PreferencesHelper
import com.android.shared.data.entity.PreferencesHelperImpl
import com.android.shared.di.scope.ActivityScope
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
        ApplicationModule.BaseModule::class,
        SharedModule::class,
    ]
)
abstract class ApplicationModule {

    /****************** Activity ******************/
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity


    /****************** Basic dependencies ******************/

    @Binds
    @Singleton
    abstract fun context(application: ForecastApplication): Context

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