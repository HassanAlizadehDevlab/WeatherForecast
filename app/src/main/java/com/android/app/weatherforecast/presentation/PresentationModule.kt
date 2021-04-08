package com.android.app.weatherforecast.presentation

import androidx.lifecycle.ViewModel
import com.android.app.weatherforecast.presentation.view.WeatherForecastViewModel
import com.android.shared.di.scope.FragmentScope
import com.android.shared.di.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(WeatherForecastViewModel::class)
    abstract fun weatherForeCastViewModel(viewModel: WeatherForecastViewModel): ViewModel

}