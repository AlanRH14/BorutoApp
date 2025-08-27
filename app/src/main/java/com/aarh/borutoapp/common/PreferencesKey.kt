package com.aarh.borutoapp.common

import androidx.datastore.preferences.core.Preferences


interface PreferencesKey <T> {
    val key: String

    val default: T

    val preferencesKey: Preferences.Key<T>
}