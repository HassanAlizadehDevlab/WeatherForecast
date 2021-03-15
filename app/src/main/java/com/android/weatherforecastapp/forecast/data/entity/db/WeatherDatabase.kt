package com.android.weatherforecastapp.forecast.data.entity.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.weatherforecastapp.forecast.data.entity.db.dao.CityDao
import com.android.weatherforecastapp.forecast.data.entity.db.model.CityEntity

/**
 * The Weather's Database.
 */
@Database(
    entities = [CityEntity::class],
    version = 1,
    exportSchema = false
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

}