package com.aarh.borutoapp.data.preferences

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import com.aarh.borutoapp.common.PreferencesKey
import com.aarh.borutoapp.util.Constants.PREFERENCES_KEY

internal sealed class ConstantsPreferences<T> : PreferencesKey<T> {

    data object OnBoardingPreferences : ConstantsPreferences<Boolean>() {
        override val key: String = PREFERENCES_KEY
        override val default: Boolean = false
        override val preferencesKey: Preferences.Key<Boolean> = booleanPreferencesKey(name = key)
    }
}