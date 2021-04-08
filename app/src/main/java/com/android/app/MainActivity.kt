package com.android.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.app.databinding.ActivityMainBinding
import com.android.shared.presentation.navigator.Navigator
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var navigator: Navigator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        if (savedInstanceState == null)
            navigator.showWeatherForeCast()
    }

}
