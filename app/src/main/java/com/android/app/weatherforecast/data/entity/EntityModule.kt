package com.android.app.weatherforecast.data.entity

import com.android.app.weatherforecast.data.entity.db.DatabaseModule
import dagger.Module

@Module(
    includes = [
        DatabaseModule::class
    ]
)
abstract class EntityModule