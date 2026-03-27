package com.example.clicker42

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.math.BigDecimal

private val Context.dataStore by preferencesDataStore("game_prefs")

class GameStorage(private val context: Context) {
    private val SCORE_KEY = doublePreferencesKey("score")
    private val AUTOCLICK_KEY = intPreferencesKey("autoclick")
    private val MULTIPLIER_KEY = intPreferencesKey("multiplier")
    private val OFFLINEINCOME_KEY = intPreferencesKey("offlineIncome")

    suspend fun getScore(): BigDecimal {
        return context.dataStore.data.map { preferences ->
            BigDecimal(preferences[SCORE_KEY] ?: "0")
        }.first()
    }

    suspend fun saveScore(score: BigDecimal) {
        context.dataStore.edit { preferences ->
            preferences[SCORE_KEY] = score
        }
    }

    suspend fun saveUpgrades(data: Map<UpgradeType, Upgrade>) {
        context.dataStore.edit { preferences ->
            preferences[AUTOCLICK_KEY] = data[UpgradeType.AutoClick]?.level ?: 0
            preferences[MULTIPLIER_KEY] = data[UpgradeType.ClickMultiplier]?.level ?: 0
            preferences[OFFLINEINCOME_KEY] = data[UpgradeType.OfflineIncome]?.level ?: 0
        }
    }

    suspend fun getAutoClick(): Int {
        return context.dataStore.data.map { preferences ->
            preferences[AUTOCLICK_KEY] ?: 0
        }.first()
    }

    suspend fun getMultiplier(): Int {
        return context.dataStore.data.map { preferences ->
            preferences[MULTIPLIER_KEY] ?: 0
        }.first()
    }

    suspend fun getOfflineIncome(): Int {
        return context.dataStore.data.map { preferences ->
            preferences[OFFLINEINCOME_KEY] ?: 0
        }.first()
    }
}