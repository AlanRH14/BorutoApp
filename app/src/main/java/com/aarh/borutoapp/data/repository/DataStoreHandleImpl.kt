package com.aarh.borutoapp.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.aarh.borutoapp.common.PreferencesKey
import com.aarh.borutoapp.domain.repository.DataStoreHandle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreHandleImpl(
    private val dataStore: DataStore<Preferences>
) : DataStoreHandle {

    override suspend fun <T> saveState(key: PreferencesKey<T>, value: T) {
        dataStore.edit { preferences ->
            preferences[key.preferencesKey] = value
        }
    }

    override fun <T> readState(key: PreferencesKey<T>): Flow<T> {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw Exception()
            }
        }.map { preferences ->
            preferences[key.preferencesKey] ?: key.default
        }
    }
}
