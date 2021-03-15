package com.android.weatherforecastapp.forecast.data.entity

import com.android.weatherforecastapp.forecast.data.entity.db.DatabaseModule
import dagger.Module

@Module(
    includes = [
        DatabaseModule::class
    ]
)
abstract class EntityModule