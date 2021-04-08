package com.android.app

import androidx.appcompat.app.AppCompatActivity
import com.android.app.weatherforecast.WeatherForeCastModule
import com.android.app.weatherforecast.presentation.view.WeatherForeCastFragment
import com.android.shared.di.scope.ActivityScope
import com.android.shared.di.scope.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [WeatherForeCastModule::class])
    abstract fun weatherForeCastFragmentInjector(): WeatherForeCastFragment

    @Binds
    @ActivityScope
    abstract fun appCompatActivity(mainActivity: MainActivity): AppCompatActivity

}