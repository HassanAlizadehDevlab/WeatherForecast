package com.android.weatherforecastapp.forecast.data.datasource.city

import com.android.weatherforecastapp.forecast.data.entity.db.dao.CityDao
import com.android.weatherforecastapp.forecast.data.entity.db.model.CityEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class CityLocalDataSourceImpl @Inject constructor(
    private val cityDao: CityDao
) : CityLocalDataSource {

    override fun cities(): Flowable<List<CityEntity>> {
        return cityDao.selectCities()
    }

    override fun insertCity(city: CityEntity): Completable {
        return Completable.fromCallable { cityDao.insert(city) }
    }

    override fun insertCities(): Completable {
        return Completable.fromCallable { cityDao.insert(getCityEntities()) }
    }


    private fun getCityEntities(): List<CityEntity> {
        return listOf(
            CityEntity(title = "Gothenburg"),
            CityEntity(title = "Stockholm"),
            CityEntity(title = "Mountain View"),
            CityEntity(title = "London"),
            CityEntity(title = "New York"),
            CityEntity(title = "Berlin"),
        )
    }

}