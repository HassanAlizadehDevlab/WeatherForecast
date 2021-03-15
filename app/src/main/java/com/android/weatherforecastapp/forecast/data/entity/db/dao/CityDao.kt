package com.android.weatherforecastapp.forecast.data.entity.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.weatherforecastapp.forecast.data.entity.db.model.CityEntity
import io.reactivex.Flowable

@Dao
interface CityDao {

    @Query("SELECT * FROM selected_cities ORDER BY title ASC")
    fun selectCities(): Flowable<List<CityEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(city: CityEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cities: List<CityEntity>)

}