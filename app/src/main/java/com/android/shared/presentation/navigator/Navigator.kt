package com.android.shared.presentation.navigator

import androidx.appcompat.app.AppCompatActivity
import com.android.app.R
import com.android.app.weatherforecast.presentation.view.WeatherForeCastFragment
import com.android.shared.presentation.extension.addFragment
import javax.inject.Inject

/**
 * Handle all navigation in here.
 *
 * @param fragmentManager is [MainActivity]'s fragmentManager.
 */
class Navigator @Inject constructor(
    activity: AppCompatActivity
) {
    private val fragmentManager = activity.supportFragmentManager


    fun showWeatherForeCast() {
        fragmentManager.addFragment(
            containerViewId = R.id.fragmentContainer,
            fragment = WeatherForeCastFragment.newInstance()
        )
    }

}