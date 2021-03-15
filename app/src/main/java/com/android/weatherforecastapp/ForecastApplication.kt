package com.android.weatherforecastapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins


class ForecastApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerForecastComponent.factory().create(this)


    override fun onCreate() {
        super.onCreate()
        initRxErrorHandler()
    }

    /**
     * RxJavaPlugins.setErrorHandler used for handle rx errors like network errors
     * */
    private fun initRxErrorHandler() {
        RxJavaPlugins.setErrorHandler {}
    }
}