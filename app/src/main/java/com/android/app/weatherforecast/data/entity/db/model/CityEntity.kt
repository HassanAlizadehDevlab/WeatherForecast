package com.android.app.weatherforecast.data.entity.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "selected_cities")
data class CityEntity(
    @PrimaryKey
    val title: String,
    val woeid: Int? = null,
    val locationType: String? = null,
    val location: String? = null,
)