package com.android.shared.data.entity

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class PreferencesHelperImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : PreferencesHelper {
    private val CITY_LIST_INSERTED = "city_list_inserted"

    override fun isCityListInserted(): Boolean {
        return sharedPreferences.getBoolean(CITY_LIST_INSERTED, false)
    }

    override fun cityListIsInserted() {
        return sharedPreferences.edit { putBoolean(CITY_LIST_INSERTED, true) }
    }
}