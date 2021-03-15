package com.android.weatherforecastapp.forecast.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.android.shared.di.scope.ActivityScope
import com.android.shared.di.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @ActivityScope
    abstract fun mainContext(activity: MainActivity): Context

}